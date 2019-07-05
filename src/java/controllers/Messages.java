
package controllers;

import beans.Message;
import database.ConnectionDB;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Messages {
    
   @RequestMapping(value="/sendMessage")
   public String sendMessage(@Valid @ModelAttribute ("message_key") Message message,BindingResult bindingResult,HttpServletRequest request) throws Exception
   {       
       if(bindingResult.hasErrors())
       {
          String failedMessage ="Sorry your message not sent to us ! please check your entered data and try again !" ;
          request.setAttribute("failed_Key",failedMessage);
          return "message" ;
       }
         
        String name=message.getName();
        String email=message.getEmail();
        String clientMessage=message.getMessage();
         
       Connection connection =  ConnectionDB.connect() ;          
       Statement statement=connection.createStatement();      
       String query =" insert into message  (name,email,message)  values( '"+name+"','"+email+"','"+clientMessage+"');  " ;
       statement.execute(query) ;  
       
       request.setAttribute("success_Key", "Your message is sent successfully ! Thanks for contact with us");
       
       
       return "message" ;
   }
}
