<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
    <title> CAM </title>
    <meta charset="utf-8">

 <link   rel="stylesheet"  href="loggedStyle.css"  type="text/css"  >
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



 <body>


 <!-- Navigation bar -->
  <!-- Home Navgation --> <a id="homeNav"> </a>  <!-- Home Navgation -->
   <header>
     <div class="container">
         <b class="logo">  VISON </b>
         <!-- Home Navgation --> <!-- -->

        <nav>
           <ul>
              <li>  <a href="#homeNav">Home</a>   </li>
              <li>  <a href="#aboutNav">About </a>   </li>
              <li>  <a href="#contactNav">Contact </a>   </li>
              <li class="user">  <a href="#"><i class="fa fa-user-o"> </i></a></li>
              <li class="logout">  <a href="index.jsp"> Log Out</a>   </li>
          </ul>
     </nav>
   </div>

   </header>

   <!-- Navigation bar -->





   <!-- search Field  -->

 <form class="search" action="search"  >

   <input type="text" placeholder="Company Name" autocomplete="off" name="searchField">
   <button type="submit">  <i class="fa fa-search"> search</i>  </button>

 </form>

  <!-- search Field  -->



     <!-- Footer Menu -->
        <!-- Contact Navgation --> <a id="contactNav"> </a>  <!-- Contact Navgation -->
        <!-- Contact Navgation --> <a id="aboutNav"> </a>  <!-- Contact Navgation -->
      <div class="parent-div">

        <div class="contactus-div">
          <h3> Contact Us </h3>
          <ul class="ul-contactus">
             <li> <i class="fa fa-map-marker">&nbsp &nbsp Cairo ,Egypt  </i> </li>
             <li> <i class="fa fa-phone">&nbsp &nbsp +2001009652433 </i> </li>
             <li> <i class="fa fa-envelope-o">&nbsp &nbsp alaaessam2009@gmail.com </i> </li>
          </ul>
         </div>


         <div class="aboutus-div">
           <h3> About Us </h3>
            <p> Give for employee a future vision<br>
               and we improvement the Companies <br>  
            </p>
         </div>


         <div class="followus-div">
           <h3 class="follow-header"> Follow Us </h3>
           <ul class="ul-followus">
             <li>  <a href="http://www.facebook.com" target="_blank">  <i class="fa fa-facebook"></i></a>  </li>
             <li>  <a href="https://twitter.com" target="_blank">  <i class="fa fa-twitter"></i></a>  </li>
             <li>  <a href="http://www.youtube.com" target="_blank">  <i class="fa fa-youtube"></i></a>  </li>
             <li>  <a href="https://www.instagram.com" target="_blank">  <i class="fa fa-instagram"></i></a>  </li>
             <li>  <a href="https://www.linkedin.com/" target="_blank">  <i class="fa fa-linkedin"></i></a>  </li>
           </ul>
          </div>


        <div class="message-div">
          <form action="sendMessage">
           <input type="text" placeholder="Name" autocomplete="off" name="name" >
           <input type="text" placeholder="Email" autocomplete="off" name="email" >
           <textarea placeholder="Message" rows="8" cols="40" name="message"></textarea>
           <input class="message-submit" type="submit" value="Send" >
         </form>
       </div>

        </div>
     <!-- Footer Menu -->






 </body>






</html
