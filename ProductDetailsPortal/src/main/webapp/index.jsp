<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Values</title>
</head>
<body>
<form method="get" action=AdderServlet>
Product ID<input type="number" name="id" required>
Product Name:<input type="text" name="pName" required>
Product Price:<input type="text" name="pPrice" required>
<button>Submit</button>
</form>
</body>
</html>