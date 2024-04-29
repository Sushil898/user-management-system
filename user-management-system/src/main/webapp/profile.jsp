<%@page import="com.org.dto.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%@ include file="components/navbarhome.jsp" %>

<% User details=(User)session.getAttribute("userOb"); %>

<h3>

   	Your Name : = <%= details.getName() %><br>
   	Your Age : = <%= details.getAge() %><br>
	Your Mobile : = <%= details.getMobile() %><br>
	Your Email : = <%= details.getEmail() %><br>

</h3><br>
<a href="update.jsp" class="btn btn-success text-decoration-none">Update</a>

</body>
</html>