
package beans;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginUser  implements Serializable{
    
    
    
    @NotEmpty(message="Please enter your email !")
    @Email(message="Please enter valid email !")
    private String email ;
    
    
    @NotEmpty(message="Please enter your password !")
    @Length(max=50,message="Password is much long !") 
    private String password ;
    
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
