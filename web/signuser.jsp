<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

 <head>
   <meta charset="utf-8">
    <title> Log in </title>

    <link rel="stylesheet" href="signuser.css" type="text/css" >

   </head>

   <h3>VISON</h3>

   <body>

  <div class="login-div">

   <form action="register">
       
    <div class="div-cont"> 
       <input type="text"  placeholder="User Name (private)" required autocomplete="off" name="username">
       <form:errors cssClass="error" path="user_info.username" />
       <p class="error"> ${errorMessageUserName_key}   </p>
    </div>
     
    <div class="div-cont"> 
      <input type="text"  placeholder="Email" required autocomplete="off" name="email"> 
      <form:errors cssClass="error" path="user_info.email" />
       <p class="error"> ${errorMessageEmail_key}   </p>
    </div>  
   
    <div class="div-cont"> 
       <input class="password" type="password" required autocomplete="off" placeholder="Password" name="password">
       <form:errors cssClass="error" path="user_info.password" />
    </div>
   
    <div class="div-cont"> 
      <input class="password" type="password" required autocomplete="off" placeholder="Confirm password" name="conf_password">
      <form:errors cssClass="error" path="user_info.conf_password" />
      <p class="error"> ${errorMessage_keyPass} <p> 
    </div>
       
    <input class="btn" type="submit" value="SIGNUP">
   
    </form>
  </div>

    </body>

</html>
