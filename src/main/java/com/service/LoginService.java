package com.service;
import com.models.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mindrot.jbcrypt.BCrypt;

import com.models.DbstoreModel;


public class LoginService {
	
	
	public String loginVerify(LoginModel loginobj)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db","root",null);
			Statement stmt=con.createStatement();  
			String query = "Select * from customer_details_table Where username='" + loginobj.getUsername() + "'";
			ResultSet rs=stmt.executeQuery(query); 
			if(rs.next())
			{
			  String encpass = rs.getString(2);
				if (BCrypt.checkpw(loginobj.getPassword(), encpass))
				return "success";
				else
					return "failed";
			}
			else
			{
				return "failed";
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
		
		
		
	}

}
