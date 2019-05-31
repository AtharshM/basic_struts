<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="jquery-3.4.1.min.js" type="text/javascript"></script>

<script type="text/javascript">

$(document).ready(function(){
	
	//processing the button
	$('.buttonhello').click(function(){
		
		$.ajax({
			
			type : "POST",
			url : 'hello.action',
			success : function(response){
				
				$('.result').html(response);
			}
		});
		
		
	});
	
	
});

</script>

</head>
<body>
<form>
   <input type="button" value="hello" class="buttonhello">
   <br>
   <div class="result"></div>
</form>

   
</body>
</html>