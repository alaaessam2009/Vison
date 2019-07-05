
package controllers;

import beans.LoginUser;
import beans.ResetPassword;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import database.ConnectionDB;
import beans.User ;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController { 
      
     
     @RequestMapping(value="/register")
      public String insertInfoUser(@Valid @ModelAttribute ("user_info")  User  user , BindingResult bindingResult , ServletRequest request) throws Exception
      {         
          if (bindingResult.hasErrors())
          {          
              return "signuser" ;
          }
    
       String username= user.getUsername() ;  
       String email =user.getEmail();
       String password=user.getPassword();
       String conPassword =user.getConf_password();
             
        Connection connection = ConnectionDB.connect() ;                 
        
        Statement statementUserName = connection.createStatement();        
        String queryUserName = "select username from user where username like '"+username+"' " ;      
        ResultSet resultSetUserName =  statementUserName.executeQuery(queryUserName);            
          if (resultSetUserName.next())
          {          
            String errorMessage= "UserName is already exist !" ;          
            request.setAttribute("errorMessageUserName_key", errorMessage); 
            return "signuser" ;
          }
              
        Statement statementEmail = connection.createStatement();        
        String queryEmail = "select email from user where email like '"+email+"' " ;      
        ResultSet resultSetEmail =  statementEmail.executeQuery(queryEmail);
             
          if (resultSetEmail.next())
          {          
            String errorMessage= "Email is already exist !" ;          
            request.setAttribute("errorMessageEmail_key", errorMessage); 
            return "signuser" ;
          }
       
        
       if(!(password.equals(conPassword)))
       {                       
         String errorMessage= "Confirm password not match your password !" ;          
         request.setAttribute("errorMessage_keyPass", errorMessage); 
         return "signuser" ;
       }
     
      
       Statement statement=connection.createStatement();      
       String query =" insert into user  (username,email,password)  values( '"+username+"','"+email+"','"+password+"');  " ;
       statement.execute(query) ;    
       
       return "registrationSuccess" ;     
      }
                
      
      
      
      
      @RequestMapping(value="/loginUser") 
       public String loginUser ( @Valid @ModelAttribute ("loginUser_Key") LoginUser loginUser ,BindingResult bindingResult, ServletRequest request ) throws Exception
       {  
           
            if (bindingResult.hasErrors())
            {
                return "login" ;
            }
           
         String email  = loginUser.getEmail();  
         String password=loginUser.getPassword();
         
           Connection connection = ConnectionDB.connect();           
           Statement statement =connection.createStatement();          
           String query="select email from user where email like '"+email+"' ";            
           ResultSet resultser = statement.executeQuery(query) ;
           
           if (resultser.next())
           {                                               
              Statement s =connection.createStatement();              
              String q="select email from user where password like '"+password+"' ";                      
              ResultSet res = s.executeQuery(q) ;
           
             if (res.next())
             {
              return "logged" ;
             }
             
            else
           {      
             String erorrMessage="Password is not correct !" ;               
             request.setAttribute("erorrMessagePass_key",erorrMessage);                     
             return "login" ; 
            }
           }
           
       else
       {                      
         String erorrMessage="This email is not register !" ;               
         request.setAttribute("erorrMessageEmail_key",erorrMessage);                     
         return "login" ; 
        }                
       }
   
   @RequestMapping(value="/resetPass")
    public  String resetPassword(@Valid @ModelAttribute ("resetPassword_key") ResetPassword resetPassword ,BindingResult bindingResult ,ServletRequest request ) throws Exception
    {  
        
      if (bindingResult.hasErrors())
      {
        return "resetPasswordPage" ;
      }
       
     ResultSet resultSet;
     String query ;
     Statement statement;
     Connection connection ;
               
    String email= resetPassword.getEmail() ;
    String password= resetPassword.getOldpassword();
    String new_Password=resetPassword.getNewPassword();       
      
    connection =ConnectionDB.connect();
    statement = connection.createStatement();            
    query ="select email from user where email like '"+email+"'"; 
    resultSet = statement.executeQuery(query) ;

    if(resultSet.next())
    {
      statement = connection.createStatement();
      query ="select email from user where email like '"+email +"' and password like '"+password+"'  " ;
      resultSet = statement.executeQuery(query) ;
      if(resultSet.next())
      {
       statement = connection.createStatement();
       query = "update user set password='"+new_Password+"' where email like '"+email+"' and password like '" +password+"'  " ;        
       statement.execute(query) ;
       return "logged" ;
      }
    else
    {      
     String erorrMessage="Old Password is not correct !" ;               
     request.setAttribute("erorrMessageOldPass_key",erorrMessage);                     
     return "resetPasswordPage" ; 
        }   
      }
     else
     {          
      String erorrMessage="This email is not register !" ;               
      request.setAttribute("erorrMessageEmail_key",erorrMessage);                     
      return "resetPasswordPage" ; 
     }        
   }
    
    
     @RequestMapping(value="/agree" , method = RequestMethod.POST)
      public String agree(@RequestParam Map<String,String> map , HttpServletRequest request) throws Exception
      {                        
        String companyName ;
        String id = map.get("idFeedBack") ;
         
         Connection connection=ConnectionDB.connect();
         Statement statement1=connection.createStatement();          
         String query1 = "select agree , name from pros where id='"+id+"' " ;
         ResultSet resultSet1 = statement1.executeQuery(query1) ;
           
           
            if (resultSet1.next())
            {
              companyName= resultSet1.getString("name");
                     
              int agreeNum =  resultSet1.getInt("agree");
              agreeNum ++ ;    
              
               Statement statement2=connection.createStatement();          
               String updateQuery = "update pros set agree= '"+agreeNum+"'  where id='"+id+"' " ;         
               statement2.execute(updateQuery);     
            }
            
            else
            {        
                
            Statement statement2=connection.createStatement();          
            String query2 = "select agree , name from cons where id='"+id+"' " ;
            ResultSet resultSet2 = statement2.executeQuery(query2) ;
            resultSet2.next();
            
            companyName= resultSet2.getString("name");
            
            int agreeNum =  resultSet2.getInt("agree");
            
            agreeNum ++ ;    
              
            Statement statement3=connection.createStatement();          
            String updateQuery = "update cons set agree= '"+agreeNum+"'  where id='"+id+"' " ;         
            statement3.execute(updateQuery);      
            }
                        
        HttpSession session=request.getSession()  ;            
        CompanyController.updateDataBase(session,companyName);
   
         return "showRating" ;
      }

      
     @RequestMapping(value="/disAgree" , method = RequestMethod.POST)
      public String disAgree(@RequestParam Map<String,String> map , HttpServletRequest request) throws Exception
      {
                  
         String companyName ;
         String id = map.get("idFeedBack") ;
          
         Connection connection=ConnectionDB.connect();
         Statement statement1=connection.createStatement();          
         String query1 = "select disagree , name from pros where id='"+id+"' " ;
         ResultSet resultSet1 = statement1.executeQuery(query1) ;
           
           
            if (resultSet1.next())
            {
              companyName= resultSet1.getString("name");
                     
              int disAgreeNum =  resultSet1.getInt("disagree");
              disAgreeNum ++ ;    
              
               Statement statement2=connection.createStatement();          
               String updateQuery = "update pros set disagree= '"+disAgreeNum+"'  where id='"+id+"' " ;         
               statement2.execute(updateQuery);     
            }
            
            else
            {        
                
            Statement statement2=connection.createStatement();          
            String query2 = "select disagree , name from cons where id='"+id+"' " ;
            ResultSet resultSet2 = statement2.executeQuery(query2) ;
            resultSet2.next();
            
            companyName= resultSet2.getString("name");
            
            int disAgreeNum =  resultSet2.getInt("disagree");
            
            disAgreeNum ++ ;    
              
            Statement statement3=connection.createStatement();          
            String updateQuery = "update cons set disagree= '"+disAgreeNum+"'  where id='"+id+"' " ;         
            statement3.execute(updateQuery);      
            }
                        
        HttpSession session=request.getSession()  ;            
        CompanyController.updateDataBase(session,companyName);
   
         return "showRating" ;
      }

}
