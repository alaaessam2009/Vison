<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>


  <head>


  <meta charset="utf-8">
    <title>Rating Company</title>


  <link rel="stylesheet" href="showRatingStyle.css" type="text/css" >
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
                      <form class="search"  action="search" name="search_field" >                          
                          <input  class="search" type="text" placeholder="Search" autocomplete="off" name="searchField">
                      <button type="submit">  <i class="fa fa-search">&nbsp  search</i>  </button>                    
                     </form>
                   </li>
                   
                    <li><a href="index.jsp">Home</a></li>
                    <li>  <a href="#contactNav">Contact </a>   </li>
                    <li> <a href="nameCompareCompanies.jsp">Comparison </a>   </li>
                  
                  <form class="form-action-rating" action="ratingCompany.jsp">     <button  class="add-review" type="submit">  <i class="fa fa-plus" aria-hidden="true">&nbsp Add your Review for this company </i>  </button>     </form> 
             
                 
              </ul>


         </nav>

       </div>

       </header>

       <!-- Navigation bar -->
     
       
       
     <%!
         
           int i ; 
              
     %>
       
       
           
     <h1 class="name"> ${nameCompanyKey} </h1>
     
     
     
     <table class="table-class">
       
              
           <tr>          
               <td> &nbsp Location </td>
                <td> ${location_key} </td>           
           </tr>
                      
           <tr>       
               <td>&nbsp Number of employees   </td>
               <td> ${num_employee_key} </td>           
           </tr>
           
           <tr>          
               <td>&nbsp founded date </td>
                <td> ${founded_date_key}  </td>            
           </tr>
           
           <tr>        
               <td>&nbsp Website </td>
               <td> <a class="websitehref" href="${website_key}" target="_blank"> ${nameCompanyKey}</a> </td>             
          </tr>
                            
           <tr>          
               <td>&nbsp industry </td>
                <td> ${industry_key}  </td>             
          </tr>
                  
     </table>
     
     
     
   
     
     <h2 class="header-cons"> Cons </h2>      
     <h2 class="header-pros"> Pros </h2>
      
    
  <div class="feedback">
       
     <div class="container-pros">
          
        <%         
           ArrayList<String> prosArr = (ArrayList)session.getAttribute("prosKey") ;
           ArrayList <String> titleProsArr = (ArrayList) session.getAttribute("titleProsKey");    
           ArrayList<Integer> iDpros = (ArrayList)session.getAttribute("iDprosKey") ;
           
           ArrayList<Integer> numAgree = (ArrayList)session.getAttribute("numAgreeForProsKey") ;
           ArrayList<Integer> numDisagree = (ArrayList)session.getAttribute("numDisAgreeForProsKey") ;
           
            for ( i=0 ; i<prosArr.size() ; i++)
             {      
        %>
                      
       <div class="pros">                 
          <i id="itag" class="fa fa-user-o"> </i>         
          <h4 class="header-feedback"> <%= titleProsArr.get(i) %>   </h4>          
          <p class="p-pros"> <%= prosArr.get(i) %>    </p>        
          
      <form id="form-agree-dis" action="agree" method="POST"  >       
          <input type="hidden"  value="<%=iDpros.get(i)%>"  name="idFeedBack" >                        
         <p class="num-agree">  <%= numAgree.get(i) %>  </p>
         <button name="btnAgree" class="btn-agree" type="submit"   > <i id="agreeIcon" class="fa fa-thumbs-up"> agree</i>   </button>  
          <p class="num-disagree">  <%= numDisagree.get(i) %> </p> 
          <button  class="btn-disagree" type="submit" formaction="disAgree" >  <i id="disagreeIcon" class="fa fa-thumbs-down"> disagree</i>      </button>          
       </form>
          
          
       </div>            
        <%      
              }      
        %>      
      </div>
         
   
     <div class="container-cons">
  
   
         <%        
           ArrayList<String> consArr = (ArrayList)session.getAttribute("consKey") ;
           ArrayList <String> titleConsArr = (ArrayList) session.getAttribute("titleConsKey"); 
        
           ArrayList <Integer> iDcons = (ArrayList) session.getAttribute("iDconsKey"); 
           
           
           ArrayList<Integer> numAgree2 = (ArrayList)session.getAttribute("numAgreeForConsKey") ;
           ArrayList<Integer> numDisagree2 = (ArrayList)session.getAttribute("numDisAgreeForConsKey") ;
           
           
           for ( i=0 ; i<consArr.size() ; i++)
            {      
         %>
     
       <div class="cons">                 
          <i id="itag" class="fa fa-user-o"> </i>         
          <h4 class="header-feedback"> <%= titleConsArr.get(i) %> </h4>          
          <p class="p-cons"> <%= consArr.get(i) %>    </p> 
          
     <form id="form-agree-dis" action="agree" method="POST"   >            
         <input type="hidden"  value="<%=iDcons.get(i)%>" name="idFeedBack" >                        
         <p class="num-agree">  <%= numAgree2.get(i) %>   </p>
         <button class="btn-agree" type="submit" > <i id="agreeIcon" class="fa fa-thumbs-up"> agree</i>   </button>  
          <p class="num-disagree"> <%= numDisagree2.get(i) %>  </p> 
          <button class="btn-disagree" type="submit" formaction="disAgree" >  <i id="disagreeIcon" class="fa fa-thumbs-down"> disagree</i>      </button>          
     </form>
          
       </div>           
        <%      
              }      
        %>
               
     </div>
         
        
        </div>
         

       <!-- Footer Menu -->
         
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



          </div>
          <!-- Contact Navgation --> <a id="contactNav"> </a>  <!-- Contact Navgation -->
          <!-- Contact Navgation --> <a id="aboutNav"> </a>  <!-- Contact Navgation -->
       <!-- Footer Menu -->



  </body>


</html>
