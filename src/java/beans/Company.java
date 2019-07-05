
package beans;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class Company  implements Serializable{   
     
   @NotEmpty(message="Please enter your Company Name !") 
   @Pattern(regexp="^[a-zA-Z0-9]{1,20}$" , message="Company name mustnot contain special characters and less than 21 letters !")
   private String name;
   
   
   @NotEmpty(message="Please enter your Company Location !")
   @Length(min=3 , max=70,message="Company name mustnot contain special characters and less than 71 letters")
   private String location;
   
   @NotEmpty(message="Please enter Website Company !")
   @Length(max=30,message="Website is very long !") 
   @Pattern(regexp="(https:\\/\\/www\\.)+[a-zA-Z0-9\\.\\-\\_]+(\\.[a-zA-Z]{2,3})+(\\/[a-zA-Z0-9\\_\\-\\s\\.\\/\\?\\%\\#\\&\\=]*)?$", message="Please enter valid website ex: https://www.name.com")
   private String web_site;
    
   
   @NotEmpty(message="Please enter number employees !")
   @Pattern(regexp="^[0-9]*$" ,message="Number employees mustnot contain a letters !")
   private String num_employee; 
   
     
   @NotEmpty(message="Please enter your Founded date of Company !")
   @Pattern(regexp="^[0-9]{4}$" ,message="date name must be in this format YYY !") 
   private String founded_date ;
   
   
   @NotEmpty(message="Please enter industry of your compnay!")
   @Pattern(regexp="^[a-zA-Z0-9]{1,25}$" , message="Industry mustnot contain special characters and must less than 26 letters !")
   private String industry ;
   
  
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeb_site() {
        return web_site;
    }

    public void setWeb_site(String web_site) {
        this.web_site = web_site;
    }

    public String getNum_employee() {
        return num_employee;
    }

    public void setNum_employee(String num_employee) {
        this.num_employee = num_employee;
    }

 
    public String getFounded_date() {
        return founded_date;
    }

    public void setFounded_date(String founded_date) {
        this.founded_date = founded_date;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    
}
