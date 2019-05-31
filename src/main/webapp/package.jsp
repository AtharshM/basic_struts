<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Package.jsp</title>

<script src="jquery-3.4.1.min.js" ></script>
<script>
$(document).ready(function(){
$('#submit').click(function(e){
    e.preventDefault();
    $.ajax({
        url:'Request_from_user.action',
        data: $("#selectPlace").serialize(), 
        type : "POST",
       
        success:function(data) {
        	
        	$('#div').html(response);
        		
       
        },
        
        error: function(data){
            alert("An error occured: " + data.status + " " + data.statusText);
          },
        complete: function (jqXHR, status) {
            alert("Local completion callback.");
          }
    });
});

});



var id=setInterval(
		 function repeat(){
		$.ajax({
			url : "Getting_the_response_from_admin.action",
			type : "GET",
			success : function(data)
			{
				
				if(data)
					{
					var result = confirm("Approve or not");
					if(result)
						{
						$.ajax({
							url : "Response_from_admin.action",
						    type : "POST",
						    data : {result : "true"}
						
						
						
						
							
						});
						clearInterval(id);
						$('#div').html("YOUR PACKAGE HAS BEEN APPROVED");
						

						}
					else 
						{
						$.ajax({
							url : "Response_from_admin.action",
						    type : "POST",
						    data : {result : "false"}
						
							
						});
						clearInterval(id);
						$('#div').html("YOUR PACKAGE HAS NOT BEEN APPROVED, KINDLY CHOOSE SOME OTHER PACKAGE");
						

						
						}
					
					
					}
				
			}
			
			
			
		});

		 }
		 ,300);
</script>


</head>
<body>

<h1>Select the places you want to visit</h1>

<form action="Request_from_user" method="post">
  <select name="selectPlace" id="selectPlace" multiple="multiple" >
  <optgroup label="COUPLES">
    <option value="Sunrise island">Sunrise island</option>
    <option value="La la land">La la land</option>
    <option value="Beach">Beach</option>
    </optgroup>
    
    <optgroup label="KIDS">
        <option value="play ground">play ground</option>
    <option value="park">park</option>
    <option value="snow world">snow world</option>
    </optgroup>
  </select>
  
 
  <input type="submit" id="submit" value="Submit">
</form>


<div id="div">

</div>




</body>
</html>