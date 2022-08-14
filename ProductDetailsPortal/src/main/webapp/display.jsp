<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Added Details</title>
</head>
<body>
<table border=2 align=center>
		<tr>
			<th>ID</th>
			<td><%=session.getAttribute("id") %></td>
		</tr>
		<tr>
			<th>Product Name</th>
			<td><%=session.getAttribute("pname") %></td>
		</tr>
		<tr>
			<th>Product Price</th>
			<td><%=session.getAttribute("pprice") %></td>
		</tr>
	</table>
</body>
</html>