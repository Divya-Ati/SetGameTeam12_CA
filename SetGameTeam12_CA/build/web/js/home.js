/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    $("#pageHeader").load("pageHeader.html"); //to include header in all pages
    $("#footer").load("footer.html");
});

function login()
{
    var email= $("#email").val();
    var psw = $("#password").val();
    //alert(email + ' ' + psw);
    var promise = $.getJSON("login",{"email":email, "password":psw});
    
       promise.done(function(data) {
           var page = data.result;
           
           if(page==='Admin')
           {
               //alert("Admin");
                window.location.href = "http://localhost:8080/onlineMarket/chat.html";
           }
              
           else if(page==='User')
           {
               //alert("usert");
               window.location.href = "http://localhost:8080/onlineMarket/products";
           }
               
           else
           {
                alert("user name and password are incorrect");
                $("#email").val("");
                $("#password").val("");
                //window.location.href = "http://localhost:8080/onlineMarket/homepage.html";
           }
               
       }).fail(function(data) {
           console.log("fail ------");
           //alert("user name and password are incorrect");
           //window.location.href = "http://localhost:8080/onlineMarket/homepage.html";
       }).always(function(data) {
           console.log("-----> always");
       });;
}

