$(function(){
            $("#myButton").click(function(){
                var val = $("#myInput").val();
                var str = val.split("").forEach(function(val) {
                        var $li = $("<p>").text(val);
                        $("span").toggleClass("main");
                        $("#mylist").append($li);
                    
                        });
                
                $("#myInput").val("");       
        });            
        });