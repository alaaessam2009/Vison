
package beans;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class ResetPassword  implements Serializable{
    
    @NotEmpty(message="Please enter your email !")
    @Email(message="Please enter valid email !")
    private String email ;
    
    @NotEmpty(message="Please enter your old Password !")
    @Length(max=50,message="password is very long !") 
    private String Oldpassword ;
    
    @NotEmpty(message="Please enter your new Password !")
    private String NewPassword ;
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOldpassword() {
        return Oldpassword;
    }

    public void setOldpassword(String Oldpassword) {
        this.Oldpassword = Oldpassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    
}
