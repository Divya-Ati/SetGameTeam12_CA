var grouplistItemTemplate = Handlebars.compile($("#grouplistItemTemplate").html());

$(document).on("pagecreate", "#first", function () {
    console.log("clicked");
    
    
$("#game-list").on("click","a[data-group]",function(){
    console.log("clicked" +$(this).attr("data-group"));
    location.hash=$(this).attr("data-group");
})


});

$(document).on("pagecontainerbeforeshow", function (_, $ui) {
    console.log("id = " +$ui.toPage.attr("id"));
    switch ($ui.toPage.attr("id")) {
        case "first":
            $.getJSON("api/gamelist")
                    .done(function (result) {
                        console.log("---> " + JSON.stringify(result));
                        $("#game-list").empty();
                        for (var i in result)
                        {
                            $("#game-list").append(
                                    grouplistItemTemplate({
                                        
                                        gameID: result[i].gameID,
                                        userID: result[i].userID,
                                        url: result[i].url
                                    }))
                        }
                        $("#game-list").listview("refresh");
                       
                    });
            break;
    }});
