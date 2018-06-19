
$(document).ready(function () {
    $("#lookupBtn").click(function () {
        var term = $("#term").val();
        $.ajax({
            url: "lookup",
            data: {'term': term},
            dataType: "json",
            type: "POST",
            success: ajaxSuccess,
            error: ajaxFailure
        });
    });
    function ajaxSuccess(data) { 
        console.log(data);
        var defs = "";
        for (var x = 0; x < data.length; x++) {
            var count = x+1;
            defs += "<p>" + count;
            defs += "(" + data[x].wordtype + ")::";
            defs += data[x].definition + "</p>";
        }
        $("#result").html(defs);
    }
    function ajaxFailure(xhr, status, exception) {
        console.log(xhr, status, exception);
    }

});
