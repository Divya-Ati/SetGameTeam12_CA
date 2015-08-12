$(function(){
            $("#btnProfile").click(function(){
                var val = $("#btnProfile").val();
                var text = '{"name":"John Johnson","street":"Oslo West 16","phone":"555 1234567"}';
                var obj = JSON.parse(text);
                document.getElementById("demo").innerHTML =
                            obj.name + "<br>" +
                            obj.street + "<br>" +
                            obj.phone;
                            });  
                        });            
    