<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DESPEDIDA</title>
</head>
<body>
<form  action="<%= request.getAttribute("baseURL") %>t7/ej20/despedirse" method="post">
Introduce un nombre<input type="text" name="nombre">
<input type="submit">
</form>

</body>
</html>