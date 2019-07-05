<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
    <head>
       <title>TODO supply a title</title>
       <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="resetPasswordPage.css" type="text/css" >
    </head>


       <h3> VISON  </h3>

       <body>

<div class="div-container">

  <form action="resetPass">
      
     <div>
       <input type="text"  placeholder="Enter your email" autocomplete="off" name="email">
       <form:errors cssClass="error" path="resetPassword_key.email" />    
       <p class="error"> ${erorrMessageEmail_key}</p>
     </div>
     
      <div>
        <input class="password" type="password" placeholder="Old password" autocomplete="off" name="Oldpassword">
        <form:errors cssClass="error" path="resetPassword_key.Oldpassword" />
        <p class="error">${erorrMessageOldPass_key} </p>
      </div>
      
     <div>
        <input class="password" type="password" placeholder="New Password" autocomplete="off" name="NewPassword">
        <form:errors cssClass="error" path="resetPassword_key.NewPassword" />
        <p class="error"> </p>
      </div>
      
      <input class="btn" type="submit" value="Confirm">

    </form>

 </div>

   </body>

    </html>
