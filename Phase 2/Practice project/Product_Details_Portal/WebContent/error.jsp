<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
<%
    Object name = request.getAttribute("name");

	Object price = request.getAttribute("price");

%>
<h2>Please enter correct details</h2>
<a href="index.jsp">Click here</a>

</body>
</html>