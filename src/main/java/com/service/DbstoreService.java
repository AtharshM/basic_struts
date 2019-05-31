package com.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.models.DbstoreModel;


public class DbstoreService {
	public String checkFunction(DbstoreModel dbstoreobj)
	{
		
		if( dbstoreobj.getPassword().equals(dbstoreobj.getConfirmpassword()))
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_db","root",null);
			
			String query = " insert into customer_details_table ( username, password,  email)"
			        + " values (?, ?, ?)";
			
			 PreparedStatement preparedStmt = con.prepareStatement(query);
		     //Encrypting passwords
			 String encpass = BCrypt.hashpw(dbstoreobj.getPassword(), BCrypt.gensalt());
			 
		     if (BCrypt.checkpw(dbstoreobj.getPassword(), encpass))
					System.out.println("The password matches.");
		     
		     
			 preparedStmt.setString (1, dbstoreobj.getUsername());
		      preparedStmt.setString (2,encpass);
		      preparedStmt.setString   (3, dbstoreobj.getMail());
		     
		      preparedStmt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		return "success";
		}
		else
			return "failed";
	}

}
