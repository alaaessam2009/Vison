
package controllers;

import beans.Company;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CompanyController {   
    
      @RequestMapping(value="/registerCompany")
       public String registerCompany (@Valid @ModelAttribute ("company_info") Company  company , BindingResult bindingResult ,HttpServletRequest request ) throws Exception
       {    
           
        if (bindingResult.hasErrors() )
       {              
         return  "signcompany" ; 
       }
      
          String name= company.getName();
          String  location = company.getLocation();       
          String founded_date =company.getFounded_date();         
          String industry= company.getIndustry();                   
          int num_emp =Integer.parseInt(company.getNum_employee());
          String website= company.getWeb_site();
                              
        /* test is date is in the past or not */        
        int date = Integer.parseInt(founded_date);                  
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if(date>year)
        {
         String message="Please enter valid date";    
         request.setAttribute("invalidDate_key",message);  
         return "signcompany" ;
         }
        /* test is date is in the past or not */
         
        
          /* test min and max values for number employess */               
         int min=2 ;         
         int max=25000;
         
         if(num_emp<min)
         {
           String message="Number employees must be bigger than 1 !";    
           request.setAttribute("min_key",message);  
           return "signcompany" ;  
         }                
         if(num_emp>max)
         {
           String message="Number employees must be less than 25000 !";    
           request.setAttribute("max_key",message);  
           return "signcompany" ;  
         }         
          /* test min and max values for number employess */        
        
        
          Connection connection = ConnectionDB.connect();             
          Statement companyStatement =connection.createStatement();          
          String q1 =" select name from company where name like '"+name+"'" ;     
          ResultSet r = companyStatement.executeQuery(q1);       
          
         if(r.next())
         {
           request.setAttribute("message_key","Sorry this company is already exist");            
           return "signcompany" ;
          }
                   
          Statement statement1 =connection.createStatement();          
          String query1 =" insert into company ( name,location,website,num_employee,founded_date,industry)  values( '"+name+"','"+location+"','"+website+"'   ,'"+num_emp+"' ,'"+founded_date+"' ,'"+industry+"' );  " ;     
          statement1.execute(query1);
                   
          Statement statement2 =connection.createStatement();              
          String query2 =" insert into pros (name)  values('"+name+"' );  " ;     
          statement2.execute(query2);
          
          Statement statement3 =connection.createStatement();              
          String query3 =" insert into cons (name)  values('"+name+"' );  " ;     
          statement3.execute(query3);
                             
          return "registrationSuccessCompany";
       }
    
     
    @RequestMapping(value="/search")
    public  String searchCompany (HttpServletRequest request) throws Exception
     {
         
      String nameCompany =request.getParameter("searchField"); 
      HttpSession session = request.getSession();      
    
  
       Connection connection =ConnectionDB.connect();
       Statement  statement1 = connection.createStatement();         
       String query1 = "select * from company where name like '"+nameCompany+"' ";            
       ResultSet resultset1 =statement1.executeQuery(query1) ;             
       if(!resultset1.isBeforeFirst())
       {          
         return "notRegisterCompany";           
       }  
       
       else
       {
         resultset1.next();  
         String companyName =resultset1.getString("name");
         session.setAttribute("nameCompanyKey",companyName);
       }
     
        String location =resultset1.getString("location");    
        String  website=resultset1.getString("website");          
        int num_emp=  resultset1.getInt("num_employee");       
        String founded_date =resultset1.getString("founded_date");       
        String industry =resultset1.getString("industry")    ;          
        String num_employee= String.valueOf(num_emp) ;
                          
       session.setAttribute("location_key", location);
       session.setAttribute("website_key", website);
       session.setAttribute("num_employee_key", num_employee);
       session.setAttribute("founded_date_key", founded_date);
       session.setAttribute("industry_key", industry);     
      
       Statement statement2 = connection.createStatement();         
       String query2 = "select pros from pros where (name like '"+nameCompany+"') and (pros like 'No pros found')  ";            
       ResultSet resultset2 =statement2.executeQuery(query2) ;       
       
       if(resultset2.next())
       {          
         return "showRatingDefault";           
       }  
              
       updateDataBase(session,nameCompany);                
       return  "showRating";       
     }
     
  
    
  @RequestMapping(value="/sendReview" , method=RequestMethod.POST)   
   public String  senReview (@RequestParam Map <String,String> map , HttpServletRequest request) throws Exception
    {              
          
       String titlePros = map.get("titlePros");
       String titleCons = map.get("titleCons");
       String pros = map.get("prosRating") ;         
       String cons = map.get("consRating") ;
          
       
       if ( pros.equals("") && cons.equals("") )
       {
         request.setAttribute("emptyProsCons_key", "Please enter pros or cons !");    
         return "ratingCompany" ;
       }
       
  

       HttpSession session = request.getSession();       
       String nameCompany = (String)session.getAttribute("nameCompanyKey") ;  
                         
       Connection connection =ConnectionDB.connect();       
       Statement statement1 = connection.createStatement();  
       String query1 = "select pros from pros where pros='No pros found'  ";      
       ResultSet resultSet1 = statement1.executeQuery(query1) ; 
        
        if(resultSet1.next())
        {
           Statement statement2 = connection.createStatement();
           String deleteQuery = "delete from pros where pros='No pros found' ";
           statement2.execute(deleteQuery) ;
        }
             
               
       Statement statement2 = connection.createStatement();  
       String query2 = "select cons from cons where cons='No cons found'  ";      
       ResultSet resultSet2 = statement2.executeQuery(query2) ; 
        
        if(resultSet2.next())
        {
           Statement statement3 = connection.createStatement();
           String deleteQuery = "delete from cons where cons='No cons found' ";
           statement3.execute(deleteQuery) ;
        }
        
     Statement  statement4 = connection.createStatement();    
     String query4 = "insert into pros (name,pros,titlepros) values( '"+nameCompany+"','"+pros+"' ,'"+titlePros+"' ) ";       
     statement4.execute(query4);
       
     Statement  statement5 = connection.createStatement();    
     String query5 = "insert into cons (name,cons,titlecons) values ('"+nameCompany+"' , '"+cons+"' ,'"+ titleCons+"')";       
     statement5.execute(query5);
        
     updateDataBase(session, nameCompany);  
     
     return "showRating";
      }
        
    
     // Conenct to database to retrieve the new data
      public static void updateDataBase(HttpSession session,String nameCompany) throws Exception
      {  
          
       Connection connection =ConnectionDB.connect();     
       Statement  statementTest1= connection.createStatement();       
       String QueryTest1 = "select pros from pros where (name like '"+nameCompany+"') and (pros='') ";           
       ResultSet resultSetTest1 =statementTest1.executeQuery(QueryTest1) ;      
           
        while(resultSetTest1.next())
        {          
           Statement  deleteStatement= connection.createStatement();       
           String deleteQuery = "delete from pros where pros='' ";
           deleteStatement.execute(deleteQuery) ; 
        }
              
       Statement  statementTest2= connection.createStatement();       
       String QueryTest2 = "select cons from cons where (name like '"+nameCompany+"') and (cons='') ";           
       ResultSet resultSetTest2 =statementTest2.executeQuery(QueryTest2) ;   
       
         while(resultSetTest2.next())
        {          
           Statement deleteStatement= connection.createStatement();       
           String deleteQuery = "delete from cons where cons='' ";
           deleteStatement.execute(deleteQuery) ; 
        }
            
       Statement  statement1= connection.createStatement();       
       String query1 = "select * from pros where name like '"+nameCompany+"' ";           
       ResultSet resultset1 =statement1.executeQuery(query1) ;        
       
       Statement  statement2= connection.createStatement();       
       String query2 = "select * from cons where name like '"+nameCompany+"' ";           
       ResultSet resultset2 =statement2.executeQuery(query2) ;   
       
        ArrayList<Integer> iDForPros= new ArrayList();        
        ArrayList<Integer> iDForCons= new ArrayList();      
             
        ArrayList<String> prosArr= new ArrayList();        
        ArrayList<String> consArr= new ArrayList();      
        
        ArrayList <String> titleProsArr = new ArrayList ();
        ArrayList <String> titleConsArr = new ArrayList ();
        
        ArrayList <Integer> numAgreeForPros = new ArrayList ();       
        ArrayList <Integer> numDisAgreeForPros = new ArrayList ();        
        ArrayList <Integer> numAgreeForCons = new ArrayList ();       
        ArrayList <Integer> numDisAgreeForCons = new ArrayList ();
              
         while(resultset1.next())
         {                                             
           prosArr.add(resultset1.getString("pros") );         
           titleProsArr.add(resultset1.getString("titlepros")); 
           iDForPros.add(resultset1.getInt("id"));
           numAgreeForPros.add(resultset1.getInt("agree"));
           numDisAgreeForPros.add(resultset1.getInt("disagree"));                              
         }
                  
          while(resultset2.next())
         {                                                     
           consArr.add(resultset2.getString("cons")   );             
           titleConsArr.add(resultset2.getString("titlecons"));           
           iDForCons.add(resultset2.getInt("id"));
           numAgreeForCons.add(resultset2.getInt("agree"));
           numDisAgreeForCons.add(resultset2.getInt("disagree"));
         }
 
       session.setAttribute("prosKey",prosArr);                 
       session.setAttribute("consKey",consArr);                  
       session.setAttribute("titleProsKey",titleProsArr);
       session.setAttribute("titleConsKey",titleConsArr); 
       session.setAttribute("iDprosKey",iDForPros); 
       session.setAttribute("iDconsKey",iDForCons);       
       session.setAttribute("numAgreeForProsKey",numAgreeForPros); 
       session.setAttribute("numDisAgreeForProsKey",numDisAgreeForPros); 
       session.setAttribute("numAgreeForConsKey",numAgreeForCons); 
       session.setAttribute("numDisAgreeForConsKey",numDisAgreeForCons); 
       
      } 
}
