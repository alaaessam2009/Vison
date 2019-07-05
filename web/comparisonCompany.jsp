<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

  <head>

  <meta charset="utf-8">
  <title>Rating Company</title>


  <link rel="stylesheet" href="comparisonCompany.css" type="text/css" >
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>


  <body>



     <!-- Navigation bar -->
      <!-- Home Navgation --> <a id="homeNav"> </a>  <!-- Home Navgation -->
       <header>
         <div class="container">

             <!-- Home Navgation --> <!-- -->

      <nav>
             <ul>
                 <li class="navgation">
                      <form class="search"  action="search" >
                          <input  class="search" type="text" autocomplete="off" placeholder="Search" name="searchField">
                      <button type="submit">  <i class="fa fa-search">&nbsp  search</i>  </button>
                     </form>
                   </li>
                    <li>  <a href="index.jsp">Home</a>   </li>
                   <li>  <a href="#contactNav">Contact </a>   </li>
                  

              </ul>

         </nav>

       </div>

       </header>

       <!-- Navigation bar -->


       
       <div class="containerCompare" >

       <div class="company1">
           
           <h2 class="nameCom1"> ${company1Key}  </h2>
           
           <p class="prosCom1">  ${prosRowNumberCom1Key} pros</p>
           <p class="consCom1">  ${consRowNumberCom1Key} cons</p>
           
       </div>

            <p class="vs">  VS </p>
         

      <div class="company2">
           
           <h2 class="nameCom2"> ${company2Key}  </h2>
           
           <p class="prosCom2">  ${prosRowNumberCom2Key} pros</p>
           <p class="consCom2">  ${consRowNumberCom2Key} cons</p>
           
           
       </div>

  

           </div>



           <div class="ContainerPrefer" >
               
              
      <p class="prefer">
         When comparing ${company1Key} and ${company2Key} , we recommends that work in ${recommendedCompany_key}  according to employees opinion.
      </p>
               
        </div>




      

       <!-- Footer Menu -->
        
          <!-- Contact Navgation --> <a id="aboutNav"> </a>  <!-- Contact Navgation -->
        <div class="parent-div">

          <div class="contactus-div">
            <h3> Contact Us </h3>
            <ul class="ul-contactus">
               <li> <i class="fa fa-map-marker">&nbsp &nbsp Cairo ,Egypt  </i> </li>
               <li> <i class="fa fa-phone">&nbsp &nbsp +209652433 </i> </li>
               <li> <i class="fa fa-envelope-o">&nbsp &nbsp alaaessam2009@gmail.com </i> </li>
            </ul>
           </div>

  <!-- Contact Navgation --> <a id="contactNav"> </a>  <!-- Contact Navgation -->
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
               <li>  <a href="https://twitter.com" target="_blank">  <i class="fa fa-twitter"></i></a></li>
               <li>  <a href="http://www.youtube.com" target="_blank">  <i class="fa fa-youtube"></i></a></li>
               <li>  <a href="https://www.instagram.com" target="_blank">  <i class="fa fa-instagram"></i></a></li>
               <li>  <a href="https://www.linkedin.com/" target="_blank">  <i class="fa fa-linkedin"></i></a></li>
             </ul>
            </div>

       <!-- Footer Menu -->



  </body>


</html>
