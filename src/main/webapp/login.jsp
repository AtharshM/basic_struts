<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<s:form action = "login" method = "post" >
         <s:textfield key = "username" name = "username" />
         <s:password key = "password" name = "password" />

         <s:submit key = "submit" />
</s:form>

</body>
</html>