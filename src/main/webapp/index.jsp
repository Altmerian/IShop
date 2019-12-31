<%@page import="java.text.SimpleDateFormat"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Order form</title>
</head>
<body>
	<form action="/order" method="post">
		<input type="hidden" name="id_customer" value="<%=request.getParameter("idCustomer")%>"> 
		Product name: <input name="product"><br> Product count:<input
			name="count" type="number"><br> <input type="submit"
			value="Make order">
	</form>
</body>
</html>

<% new SimpleDateFormat("yyyy").parse("1999"); %>
