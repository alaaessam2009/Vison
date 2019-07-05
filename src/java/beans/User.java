
package beans;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class User implements Serializable {
    
    
      @NotEmpty(message="Please enter your UserName !")
      @Pattern(regexp="^[a-zA-Z0-9]{1,15}$" , message="username mustnot contain special characters and less than 16 letters !")
      private String username ;
     
      @NotEmpty(message="Please enter your email !")
      @Email(message="Please enter valid email !")
      private String email ;
      
      @NotEmpty(message="Please enter your Password !")
      @Length(max=50,message="password is very long !") 
      private String password ;
      
      @NotEmpty(message="Please enter your Confirm Password!")
      private String conf_password ;
          
    public String getConf_password() {
        return conf_password;
    }

    public void setConf_password(String conf_password) {
        this.conf_password = conf_password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
}
