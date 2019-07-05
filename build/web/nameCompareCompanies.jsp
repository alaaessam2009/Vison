<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>

 <link rel="stylesheet" href="nameCompareCompaniesStyle.css" type="text/css" >

  </head>


  <body>
    
      
   <div class="div-container">

     <form action="ComparisonCompanies">

        <div>
            <input type="text" placeholder="First company" required autocomplete="off" name="company1">
          <form:errors cssClass="error" path="nameCompanies_key.company1" />
        </div>
        
     
       <div>
          <input type="text" placeholder="Second company" required autocomplete="off" name="company2" >
          <form:errors cssClass="error" path="nameCompanies_key.company2" />
       </div>
       
          <p class="p-container"> ${equalCompany_key} </p>
       
        <input class="submitBtn" type="submit" value="Compare" >

     </form>

  </div>
      
      
  </body>


</html>
