<!DOCTYPE html>


<html>
  <head>
    <meta charset="utf-8">
    <title>Rating</title>

  <link rel="stylesheet" href="ratingCompany.css" type="text/css" >

  </head>

  <body>

   <div class="div-container">
   <form action="sendReview" method="POST">
      
     <textarea class="title-pros" name="titlePros" rows="2" cols="80"   placeholder=" title of pros ..."></textarea>   
     <textarea class="textarea-pros" name="prosRating" rows="8" cols="80"   placeholder=" Write your pros here ..."></textarea>        
     <textarea class="title-cons" name="titleCons" rows="2" cols="80"   placeholder=" title of cons ..."></textarea> 
     <textarea class="textarea-cons" name="consRating" rows="8" cols="80"  placeholder=" Write your cons here ..."></textarea>    
     <p class="error"> ${emptyProsCons_key}</p>
     <input class="review" type="submit" value="Review">    
     
   </form>
     
   </div>


  </body>



</html>
