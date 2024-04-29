package com.org.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/change")
public class changepwdServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		
		HttpSession session = req.getSession();
				
		UserDao dao = new UserDao();
		List<User> list = dao.fetchAllUsers();
		
		for(User u : list){
			
			if(password.equals(u.getPassword())){
				
				if (password1.equals(password2)) {
					
					User user = new User();
					
					user.setPassword(password1);
					
					dao.saveUser(user);
					
					session.setAttribute("success", "Password Changed Successfully");
					
					resp.sendRedirect("changepwd.jsp");	
				}
				else {
					
					session.setAttribute("success", "New password and Confirm Password not matched");
					
					resp.sendRedirect("changepwd.jsp");
				}
			}
			else {
				session.setAttribute("success", "You Enterd Wrong Old password");
				
				resp.sendRedirect("changepwd.jsp");
			}
	}
 }
}