<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Primer JSP</title>
</head>
<body>
	<%
		for (int i = 1; i < 5; i++) {
			response.getWriter().println("<h" + i + ">HOLA</h" + i + ">");
		}
	%>
</body>
</html>