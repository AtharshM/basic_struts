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
<s:form action = "DbaccessAction.action" method = "post" enctype = "multipart/form-data">
         <s:textfield key = "username" name = "username" />
         <s:password key = "password" name = "password" />
          <s:password key = "confirm password" name = "confirmpassword" />
         <s:textfield key = "mail-id" name = "mail" />
         <s:submit key = "submit" />
      </s:form>
</body>
</html>