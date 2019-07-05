
package beans;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class Message implements Serializable {
     
    
   @NotEmpty(message="Please enter your Name !") 
   @Length(min=3,max=25,message="Name mustnot less than 3 and longer than 25 ")
   private String  name ;  
    
   @Email(message="Please enter valid email address !")
   private String email ;  
   
 
   private String  message;
    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
   
   
    
    
    
   
}
