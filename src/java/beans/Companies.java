
package beans;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

public class Companies implements Serializable {
    
    
    @NotEmpty(message="Please enter name of company !")
    @Pattern(regexp="^[a-zA-Z0-9]{1,15}$" , message="Company name mustnot contain special characters and less than 16 letters !")
    
    private String company1 ;
    
    @NotEmpty(message="Please enter name of company !")
    @Pattern(regexp="^[a-zA-Z0-9]{1,15}$" , message="Company name mustnot contain special characters and less than 16 letters !")
    private String company2 ;

    
    public String getCompany1() {
        return company1;
    }

    public void setCompany1(String company1) {
        this.company1 = company1;
    }

    public String getCompany2() {
        return company2;
    }

    public void setCompany2(String company2) {
        this.company2 = company2;
    }
      
}
