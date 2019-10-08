$(document).ready(
    function() {

        $("#commandForm").submit(function(event) {
            event.preventDefault();
            parseCommand();
        });

        function parseCommand() {
            $("#centerCluster tbody").empty();
            var unparsedCommand = {
                command : $("#unparsedCommand").val()
            }
            document.getElementById("commandForm").reset();
            $("#errorDisplay").html("<strong>"+"</strong>");
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "newCommand",
                data: JSON.stringify(unparsedCommand),
                dataType : 'json',
                cache: false,
                statusCode: {
                    200: function(result) {
                        displayResult();                  
                    }
                },
                error : function(e) {
                    $("#errorDisplay").html("<strong>"+e.responseJSON.message+"</strong>");
                }
            });

        }

        function displayResult() {
            $.ajax({
                type : "GET",
                url : "latestCommandResult",
                cache: false,
                statusCode: {
                    200: function(response) {
                        var html ='';
                        if(response.command.signature === "opn"){
                            window.open(response.result[0], '_blank');
                        }else if(response.command.signature === "darkmode" ||response.command.signature === "defaultmode" ){
                            window.open(response.result[0], '_blank');
                            window.close();
                        }else {
                            $(response.result).each(
                                function() {
                                    html+= 
                                        '<tr>'
                                        +'<td><img src="'+this.icon+'"></img></td>'
                                        +'<td></td>'
                                        +'<td class="pageNameAlias"><a href="'+this.link+'" style="text-decoration: none" target="_blank">'+this.alias+'</a></td>'
                                        +'</tr>';
                                    
                                }
                            );
                            $("#centerCluster tbody").append(html);
                        }
                                           
                    },
                    406:
                    function(e) {
                        $("#errorDisplay").html("<strong>"+e.responseJSON.message+"</strong>");
                    }
                }
            });

        }
    }

    
)