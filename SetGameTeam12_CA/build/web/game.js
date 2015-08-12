var imageurl = new String();  // insert selecting image

var imageurlpointingplace = new String();//used to place index of original place but not yet got 
var imagefirsturl = new String();  //original images with original indexes but not yet done

var currentGame;
var selectedCount = 0;
var selectedCards = [3];
var img =[];
 var count =0;
function drawRow(cardData, row) {
    onClick='checkGameRules("+cardData.imageUrl+")'
    row.append($("<td>" + "<input  type='image' src='" + cardData.imageUrl
            + "' id='" + cardData.id
            + "' width='50' height='50' onclick='checkGameRules(this.id)'>" + "</td>"));
   // console.log(cardData.imageUrl);
    var i = 0;
    if (imagefirsturl.length >= 1) {
        i++;
        imageUrl
    }
    imagefirsturl[i] = cardData.imageUrl;
  //  console.log("this is in the imagefirsturl    " + imagefirsturl[i]);

};


function resume(gameId) {
    //$.getJSON("api/game/openExistingGame/?id=" + id)
    currentGame = gameId;
    $.getJSON("api/cardsOnTable/getTableCards/?id=" + gameId)
            .done(function (data) {
               
                showCardsOnTable("#table", data.cards);
            }).fail(function () {
        console.log("Not Found");
    });
};
function showCardsOnTable(tableId, cards) {
    // To clear all rows inside the table
    $(tableId).empty();
    // Add row based on return data
    var row = $("<tr />");
    $(tableId).append(row);
    for (var i = 0, il = cards.length; i < il; i++) {
        if (i % 3 === 0) {
            row = $("<tr />");
            $(tableId).append(row);
        }
        drawRow(cards[i], row);
    }
};




var source;
$(function () {

  source = new EventSource("api/chatroom");
    source.onmessage = function(event) {
        console.log("got message");
       var chat = JSON.parse(event.data);
        var $messages = $("#messages");
      console.log(">> msg = " + JSON.stringify(chat));
       $messages.text(chat.name + ": " + chat.image1 +" " +chat.image2 + " " + chat.image3 + " " + "\n" 
               + $messages.text());
       
         //var pONumb = ${sessionScope.uname};
//         var mySessionVar ='<%=Session["uname"]%>';
//         console.log("session :"+mySessionVar);
//        $("#userlist").append();
//        //
    };
   

  
   
$(".sendid").on("click",(function(){
    img[count] = this.id;
    count++;
    if(count === 3)
    {    
        for(var i=0;i<3;i++)
        {
          console.log(img);
       
          checkGameRules(img[i]);
        }
        count=0;
    }
    //selectedCards[count] = this.id;
    
  
}));

$("#btnsubmit").on("click",(function(){
    for(var i=0;i<3;i++)
    {
        console.log(img);
       
        checkGameRules(img[i]);
    }
    $.get("/SetGameTeam11CA/newMessage", { 
           name: $("#name").val(),
           image1: img[0],
           image2: img[1],
           image3: img[2]
           
       }).done(function() {
           //GameRules(img);
       
//          $("#name").text=" ";
//          img[0].value = '';
//          img[1].value = '';
//          img[2].value = '';
       });
   })); 







function checkGameRules(id) {
    selectedCount++;
    selectedCards[selectedCount - 1] = id;
    if (selectedCount === 3) {
       // var Gameid = document.getElementsByName('Gameid')[0].value;
       
       
        $.getJSON("api/cardsOnTable/checkTableCards/?id=1"
                + "&card1=" + selectedCards[0]
                + "&card2=" + selectedCards[1]
                + "&card3=" + selectedCards[2])
                .done(function (data) {
                    if (data.status) {
                        count = 0;
                        selectedCount = 0;
                        selectedCards = [];
                        //alert(data.status);
                        console.log("data status ------> "+data.status);

                        showCardsOnTable("#table",data.cards);
                        showCardsOnTable("#setTable",data.setCards);
                        
                    } else {
                        showCardsOnTable("#setTable",data.setCards);
                    }
                }).fail(function () {
            console.log("Not Found");
        });
    }
}
}
 )

$(function () {
  
    $("#btnHint").on("click", function () {
        $.getJSON("api/game/getAllCards/")
                .done(function (data) {
                    // To clear all rows inside the table
                    $("#table").empty();
                    // Add row based on return data
                    var row = $("<tr />")
                    $("#table").append(row);
                    for (var i = 0, il = data.cards.length; i < il; i++) {
                        if (i % 3 === 0) {
                            row = $("<tr />")
                            $("#table").append(row);
                        }
                        drawRow(data.cards[i], row);
                    }
                }).fail(function () {
            console.log("Not Found");
        });
    });

    $("#btnShuffle").on("click", function () {
        $.getJSON("api/game/getShuffleCards/")
                .done(function (data) {
                    showCardsOnTable("#table",data.cards);
                }).fail(function () {
            console.log("Not Found");
        });
    });

    $("#btnNewGame").on("click", function () {

        $.getJSON("api/game/createNewGame/")
                .done(function (data) {
                    // Add row based on return data
                    var row = $("<tr id=" + data.id + "/>");
                    $("#games").append(row);
                  row.append($("<td>" + data.id + "</td>"));
                    row.append($("<td>" + data.creator + "</td>"));
                    row.append($("<td>" + data.date + "</td>"));
                    row.append($("<td><button class='btnResume' value='" + data.id + "' onclick='resume(" + data.id + ")'>Start</button></td>"));
                    console.log (data.id);
                }).fail(function () {
            console.log("Not Found");
        
            });
    });
     });
    