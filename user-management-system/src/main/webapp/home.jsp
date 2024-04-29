<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
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
<% User sessionuser = (User) session.getAttribute("userOb");
if(sessionuser == null){
	response.sendRedirect("login.jsp");
}
else{
%>
<%@ include file="components/navbarhome.jsp" %>

<h1 class="text-center">Hey
 <%= sessionuser.getName() %>
 ,welcome to user management system</h1>
 <div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<% String msg= (String)session.getAttribute("success");
						if(msg != null){
						%>
						<p class="text-center text-success fs-4"><%= msg %></p>
						<%
						session.removeAttribute("success");
						}
						%>
						<a href="adduser.jsp" class="text-decoration-none btn btn-primary">Add User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>
								<% 
								UserDao dao = new UserDao();
								List<User> list = dao.fetchAllUsers();
								
								for(User u : list){
									
									if(sessionuser.getId()==u.getId()){
									
										continue;
									}
								%>
								<tr>
									<td><%= u.getName() %></td>
									<td><%= u.getAge() %></td>
									<td><%= u.getEmail() %></td>
									<td><%= u.getMobile() %></td>
									<td><a href="update.jsp?id=<%= u.getId() %>" 
									class="btn btn-success text-decoration-none">Update</a>
										<a href="#" class="btn btn-danger text-decoration-none">Delete</a>
									</td>
								</tr>
								<% } %>

							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
	<%} %>
</body>
</html>