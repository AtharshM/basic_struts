package com.action;

import com.service.DbstoreService;
public class DbaccessAction {
   private String username;
   private String password;
   private String confirmpassword;
   private String mail;
	public String execute()
	{
		System.out.println("sad");
		
		
		setUsername(username);
		setPassword(password);
		setConfirmpassword(confirmpassword);
		setMail(mail);
		
		
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
