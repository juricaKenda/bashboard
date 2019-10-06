$(document).ready(
    function() {

        $("#commandForm").submit(function(event) {
            event.preventDefault();
            parseCommand();
        });

        function parseCommand() {

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
                        console.log("Succesfully parsed the command");
                        displayResult();                  
                    }
                },
                error : function(e) {
                    $("#errorDisplay").html("<strong>"+e.responseJSON.message+"</strong>");
                    console.log("ERROR: ", e);
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
                        console.log(response.result);
                        var html ='';
                        if(response.result.length > 1){
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
                            $("#centerCluster tbody").empty();
                            $("#centerCluster tbody").append(html);
                        }else{
                            window.open(response.result[0], '_blank');
                        }
                                           
                    }
                }
            });

        }
    }

    
)