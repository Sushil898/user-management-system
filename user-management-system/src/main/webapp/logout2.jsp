
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession s = request.getSession(false);
if (session != null) {
	
	session.invalidate();
	
	response.sendRedirect("login.jsp");
 }
%>
</body>
</html>