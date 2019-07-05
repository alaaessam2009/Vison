
package controllers;

import database.ConnectionDB;
import beans.Companies;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComparisonCompany {

     @RequestMapping(value="/ComparisonCompanies")
      public ModelAndView compare ( @Valid @ModelAttribute ("nameCompanies_key")  Companies companies , BindingResult bindingResult) throws Exception
      {
           int prosRowNumberCom1=0 ;
           int consRowNumberCom1=0 ;
           int consRowNumberCom2=0 ;        
           int prosRowNumberCom2=0 ;
          
          
         if(bindingResult.hasErrors())
         {
           ModelAndView modelAndView1 = new ModelAndView("nameCompareCompanies");    
           return modelAndView1 ; 
         }
         
         String company1=companies.getCompany1();
         String company2=companies.getCompany2();
         
         if(company1.equals(company2))
         {
             ModelAndView modelAndView = new ModelAndView("nameCompareCompanies");
             modelAndView.addObject("equalCompany_key", "Please enter different companies to compare between them !");
             return modelAndView ;
         }
          
          
         ModelAndView modelAndView1 = new ModelAndView("notRegisterCompany");   
           
         boolean firstcompanyIsExist =false;
         boolean secondcompanyIsExist =false ;
          
       
         
         if(company1.equals(company2))
         {
             
             return null ;  
         }
             
         
                     
         Connection connection =ConnectionDB.connect();
         Statement statementComp1 =connection.createStatement();         
         String queryComp1 ="select name from company where name like '"+company1+"' " ;      
         ResultSet resultSetComp1 =statementComp1.executeQuery(queryComp1);
         
         Statement statementComp2 =connection.createStatement();         
         String queryComp2 ="select name from company where name like '"+company2+"' " ;      
         ResultSet resultSetComp2 =statementComp2.executeQuery(queryComp2);
                 
          if(resultSetComp1.next())
          {
             firstcompanyIsExist=true ;           
          }        
          if (resultSetComp2.next())
          {
             secondcompanyIsExist=true; 
          }     
          
           resultSetComp1.previous();
           resultSetComp2.previous();             
          
        
           
        if (firstcompanyIsExist && secondcompanyIsExist)
        {
                      
                                      
           Statement statement1 =connection.createStatement();           
           String query1 = "select name from pros where name like '"+company1+"'  " ;           
           ResultSet resultSet1 = statement1.executeQuery(query1);              
          
           while(resultSet1.next())
           {
               prosRowNumberCom1=resultSet1.getRow();
           }                    
           Statement statement2 =connection.createStatement();           
           String query2 = "select name from cons where name like '"+company1+"'  " ;           
           ResultSet resultSet2 = statement2.executeQuery(query2);
                
         
           while(resultSet2.next())
           {
               consRowNumberCom1=resultSet2.getRow();
           }
                     
            
           Statement statement3 =connection.createStatement();           
           String query3 = "select name from pros where name like '"+company2+"'  " ;           
           ResultSet resultSet3 = statement3.executeQuery(query3); 
           
           while(resultSet3.next())
           {
               prosRowNumberCom2=resultSet3.getRow();
           }           
                 
           Statement statement4 =connection.createStatement();           
           String query4 = "select name from cons where name like '"+company2+"'  " ;           
           ResultSet resultSet4 = statement4.executeQuery(query4);
                
         
           while(resultSet4.next())
           {
               consRowNumberCom2=resultSet4.getRow();
           }
 
        
            
          String recommendedCompany = null ;
           
          if((prosRowNumberCom1 > prosRowNumberCom2) && (consRowNumberCom1 < consRowNumberCom2))
           {
             recommendedCompany=company1;
           }   
               
          else if ((prosRowNumberCom1 < prosRowNumberCom2) && (consRowNumberCom1 > consRowNumberCom2))
           {
              recommendedCompany=company2;
           }
          
          else if ((consRowNumberCom1 > consRowNumberCom2))
          {
             recommendedCompany=company2;
          }
          
          else
          {
             recommendedCompany=company1;
          }
          
          
                   
   /* Delete No pros and No cons from numbers of pros and cons */
    Statement s1 = connection.createStatement();  
    String q1 = "select pros from pros where (name like '"+company1+"') and (pros='No pros found')  ";      
    ResultSet r1 = s1.executeQuery(q1) ;      
    if(r1.next())
    {
        prosRowNumberCom1 -- ;
    }
      
    Statement s2 = connection.createStatement();  
    String q2 = "select cons from cons where (name like '"+company1+"') and (cons='No cons found')  ";      
    ResultSet r2 = s2.executeQuery(q2) ; 
        
    if(r2.next())
    {
      consRowNumberCom1 -- ;
    }
                                
    Statement s3 = connection.createStatement();  
    String q3 = "select pros from pros where (name like '"+company2+"') and (pros='No pros found')  ";      
    ResultSet r3 = s3.executeQuery(q3) ;      
    if(r3.next())
     {
        prosRowNumberCom2 -- ;
      }     
     Statement s4 = connection.createStatement();  
     String q4 = "select cons from cons where (name like '"+company2+"') and (cons='No cons found')  ";      
     ResultSet r4 = s4.executeQuery(q4) ;       
    if(r4.next())
    {
      consRowNumberCom2 -- ;  
    }
   /* Delete No pros and No cons from numbers of pros and cons */
           
          
           ModelAndView modelAndView = new ModelAndView("comparisonCompany");           
           modelAndView.addObject("company1Key",company1);
           modelAndView.addObject("company2Key",company2);         
           modelAndView.addObject("prosRowNumberCom1Key",prosRowNumberCom1);
           modelAndView.addObject("consRowNumberCom1Key",consRowNumberCom1);          
           modelAndView.addObject("prosRowNumberCom2Key",prosRowNumberCom2);
           modelAndView.addObject("consRowNumberCom2Key",consRowNumberCom2);              
           modelAndView.addObject("recommendedCompany_key", recommendedCompany);
            
       
          return modelAndView ;           
        }
      
       
        if(firstcompanyIsExist==false)
        {                
         modelAndView1.addObject("company1_key",company1);      
        }
             
        if (secondcompanyIsExist==false)
        {          
           modelAndView1.addObject("company2_key",company2);      
        }
        
         return modelAndView1 ;
       
      }    
}
