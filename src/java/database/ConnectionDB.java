
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionDB {
    
  
     public static Connection connect () throws Exception
     {
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url ="jdbc:mysql://localhost/vision";      
          String userAccount="root";     
          String password="root";
          Connection connection = DriverManager.getConnection(url,userAccount,password);               
         return connection ;  
     }
    
    
}
