<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

 <head>
   <meta charset="utf-8">
    <title> Log in </title>
    <link rel="stylesheet" href="stylelogin.css" type="text/css" >
   </head>

   <h3> VISON  </h3>

   <body>
       
   <div class="login-div">
      
   <form action="loginUser">
       <div class="div-email"> 
          <input type="text" placeholder="Email" required autocomplete="off" name="email">
          <form:errors path="loginUser_Key.email" cssClass="error" /> 
          <p class="error"> ${erorrMessageEmail_key} </p>
       </div>
       
      <div class="div-password">
        <input class="password" type="password" required placeholder="Password" autocomplete="off" name="password">
        <form:errors path="loginUser_Key.password" cssClass="error" />
        <p class="error"> ${erorrMessagePass_key} </p>
      </div>
      
      <a href="resetPasswordPage.jsp">Reset your password</a>
      <a href="signuser.jsp">Create an account</a>
      <input class="btn" type="submit" value="LOGIN">
   </form>
 
  </div>

    </body>


</html>
