<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Struts2 Action Mapping Example</title>
</head>
<body>
 
 
 
 	  <s:form action = "index.action" method = "post" enctype = "multipart/form-data">
         <s:textfield label="Enter the company name" key = "secondoutput" />
         <s:submit key = "submit" />
      </s:form>
      

</body>
</html>