<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style> table,td,th {border:1px solid green; padding:10px;}</style>
<meta charset="UTF-8">
<title>View product</title>
</head>
<body>
<%
    Object name = request.getAttribute("name");

	Object price = request.getAttribute("price");

%>
<h2 style='color:blue'>Product Details Table</h2><br/>
<table>
<tr>
<th>Product name</th>
<th>Product price</th>
</tr>
<tr>
<td><%=name%></td>
<td><%=price%></td>
</tr>
</table>
</body>
</html>
