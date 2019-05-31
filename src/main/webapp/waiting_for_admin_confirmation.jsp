<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>
$('#submit').on('click', function(e){
    e.preventDefault();
    $.ajax({
        url:'AjaxAction.action',
        data: {place_name: document.getelementbyid("placeId").value}, 
        type : "POST",
        success:function(data) {
       
        }
    });
});
</script>


</head>
<body>

<h1>Select the places you want to visit</h1>

<form action="ajax" method="post" disabled >
  <select name="placeId" id="placeId" multiple="multiple" >
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
  <input type="submit" id="submit" value="Submit" disabled>
</form>

</body>
</html>