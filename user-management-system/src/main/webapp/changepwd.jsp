<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@ include file="components/navbarhome.jsp" %>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Change Password</p>
						<% String msg= (String)session.getAttribute("success");
						if(msg != null){
						%>
						<p class="text-center text-success fs-4"><%= msg %></p>
						<%
						session.removeAttribute("success");
						}%>
						<form action="change" method="post">
							
							<div class="mb-3">
								<label class="form-label"> Old Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">New Password</label> <input
									name="password1" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Confirm Password</label> <input
									name="password2" type="password" class="form-control" required>
							</div>
							
							
							<button type="submit" class="btn bg-primary text-white col-md-12">SUBMIT</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>