/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
  
   var promise =  $.getJSON("header");
   promise.done(function(data){
       if(!data.username)
       {
           $("#userName").text("");
           $("#logout").text("");
           
       }
       else
       {
           $("#userName").text(data.username);
           $("#logout").text(" Logout");
           $("#logout").prepend(
                   $("<span/>",{
                       class:'glyphicon glyphicon-log-out'
                   }));
           
       }
   });
    
});

