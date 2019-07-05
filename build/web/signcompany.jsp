<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>


<html>

 <head>
   <meta charset="utf-8">
    <title> Log in </title>

    <link rel="stylesheet" href="signcompany.css" type="text/css" >

   </head>


   <h3> VISON  </h3>

   <body>

       <div class="div-container">


   <form action="registerCompany" method="GET"  >
       
    <div class="div-name">
        <input type="text"  placeholder="Company Name" required autocomplete="off" name="name"> 
       <form:errors cssClass="error" path="company_info.name" />     
       <p class="div-p"> ${message_key}</p> 
    </div>
    
   <div class="div-location">
      <input type="text"  placeholder="Location" required autocomplete="off" name="location">
      <form:errors cssClass="error" path="company_info.location" /> 
   </div>
   
   <div class="div-website">
      <input type="text"  placeholder="URL of Website" required autocomplete="off" name="web_site" > 
      <form:errors cssClass="error" path="company_info.web_site" />
   </div>
   
   <div class="div-num-employee">
      <input type="text"  placeholder="Number of employees" required autocomplete="off" name="num_employee"> 
      <form:errors cssClass="error" path="company_info.num_employee" />
      <p class="error">${min_key}</p>
      <p class="error">${max_key}</p>
   </div>  
  
   <div class="div-founded-date">
      <input type="text"  placeholder="Founded date" required autocomplete="off" name="founded_date">
      <form:errors cssClass="error" path="company_info.founded_date" /> 
      <p class="error"> ${invalidDate_key}</p>
   </div>
     
   <div class="div-industry">
      <input type="text"  placeholder="Industry" required autocomplete="off" name="industry"> 
      <form:errors cssClass="error" path="company_info.industry" /> 
   </div>

   <input class="btn" type="submit" value="SIGNUP">
   
   </form>

  </div>


    </body>

</html>
