package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import com.org.dto.User;

public class UserDao {
	
	public void saveUser(User user) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-mgmt","root","root");
			PreparedStatement pst = con.prepareStatement
					("insert into user(name,age,email,password,mobile)values(?,?,?,?,?)");
			
			
			pst.setString(1,user.getName());
			pst.setInt(2,user.getAge());
			pst.setString(3,user.getEmail());
			pst.setString(4,user.getPassword());
			pst.setLong(5,user.getMobile());
			
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace()
			;
		}
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		
		try {
			
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-mgmt","root","root");
			 PreparedStatement pst = con.prepareStatement("select * from user where email = ? and password = ?");
			 
			 pst.setString(1, email);
			 pst.setString(2, password);
			 
			 ResultSet rst = pst.executeQuery();
			 
			 if (rst.next()) {
				
				 User user = new User();
				 
				    user.setName(rst.getString("name"));
					user.setAge(rst.getInt("age"));
					user.setMobile(rst.getLong("mobile"));
					user.setEmail(rst.getString("email"));
					user.setPassword(rst.getString("password"));
					
					return user;
			}
			 con.close();
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	
	}
	public User fetchUserById(int id) {
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-mgmt","root","root");
		 PreparedStatement pst = con.prepareStatement("select * from user where id = ?");
		 
		 pst.setInt(1, id);
		 
		 ResultSet rst = pst.executeQuery();
		 
		 if (rst.next()) {
			
			 User user = new User();
			 	user.setId(rst.getInt("id"));
			    user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setMobile(rst.getLong("mobile"));
				user.setEmail(rst.getString("email"));
				user.setPassword(rst.getString("password"));
				
				return user;
		}
		 con.close();
		 
	} 
	catch (Exception e) {
		// TODO: handle exception	
	}
		return null;
	}
	public List<User> fetchAllUsers(){
		
		List<User> list = new ArrayList<>();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-mgmt","root","root");
			 PreparedStatement pst = con.prepareStatement("select * from user ");
			 
			
			 
			 ResultSet rst = pst.executeQuery();
			 
			 while (rst.next()) {
				
				 User user = new User();
				 	user.setId(rst.getInt("id"));
				    user.setName(rst.getString("name"));
					user.setAge(rst.getInt("age"));
					user.setMobile(rst.getLong("mobile"));
					user.setEmail(rst.getString("email"));
					user.setPassword(rst.getString("password"));
					
					 list.add(user);
					 }
			 con.close();
			 
		} 
		catch (Exception e) {
			// TODO: handle exception	
		}
			return list;
		
	}
	
}
