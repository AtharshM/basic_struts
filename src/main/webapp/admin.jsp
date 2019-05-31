<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ page import="com.models.PlacesModel" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="jquery-3.4.1.min.js" ></script>
<script>
var id=setInterval(
 function repeat(){
$.ajax({
	url : "Getting_the_request_from_user.action",
	type : "GET",
	success : function(data)
	{
		if(data=="true")
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

				}
			else if(data=="false")
				{
				$.ajax({
					url : "Response_from_admin.action",
				    type : "POST",
				    data : {result : "false"}
				
					
				});
				clearInterval(id);

				
				}
			
			
			}
		
	}
	
	
	
});

 }
 ,300);
</script>
</head>
<body>
<h1>selected places are:</h1>
<s:property value="placeId"/>
</body>
</html>