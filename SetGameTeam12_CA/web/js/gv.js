$(function() {
          $.getJSON("gv")         
                .done(function(result) {                  
               $("#mylist").append($li);
                    
                }).fail(function() {
                    $("#message").text("Member not found");
                   
                });        
    });


