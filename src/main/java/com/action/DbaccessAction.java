package com.action;

import com.service.DbstoreService;
import com.service.LoginService;
import com.service.PlacesService;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.models.DbstoreModel;
import com.models.LoginModel;
import com.models.PlacesModel;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

public class DbaccessAction implements SessionAware, ParameterNameAware {

	   private String username;
	   private String password;
	   private String confirmpassword;
	   private String mail;
	   private String placeId;
	   
	   private Map<String, Object> userSession;
	   
	private DbstoreModel dbobject;
	private LoginModel loginobj;
	private PlacesModel placeobj;
	
	public String registerFunction()
	{
		//System.out.println("sad");
		setUsername(username);
		setPassword(password);
		setMail(mail);
		setConfirmpassword(confirmpassword);
		dbobject = new DbstoreModel();
		
		dbobject.setUsername(getUsername());
		dbobject.setPassword(getPassword());
		dbobject.setConfirmpassword(getConfirmpassword());
		dbobject.setMail(getMail());
		
		
		
		
//		System.out.println(dbobject.getPassword());
//		System.out.println(dbobject.getConfirmpassword());
		
		
		DbstoreService dbserviceobj = new DbstoreService();
	
		return dbserviceobj.checkFunction(dbobject);
		
	}
	
	
	
	
	public String loginFunction()
	{
		
		System.out.println(username);
		
		LoginService loginserviceobj = new LoginService();
		loginobj = new LoginModel();
		loginobj.setUsername(getUsername());
		loginobj.setPassword(getPassword());
		String validUser = loginserviceobj.loginVerify(loginobj);
		if(validUser.equals("success"))	{
			userSession.put("username", username);
			userSession.put("password",password);
			return "success";
		}
		return "failed";
	}
	
	
	
	
	
	
	public String selectFunction()
	{
		userSession.put("placeId", getPlaceId());
		
		placeobj = new PlacesModel();
		System.out.println("saddsfadsfdsf");
		System.out.println(getPlaceId());
		placeobj.setPlaceId(getPlaceId());
		
		PlacesService placesService = new PlacesService();
		System.out.println(placeobj.getPlaceId());
		
		setUsername(userSession.get("username").toString());
		setPassword(userSession.get("password").toString());
		setPlaceId(userSession.get("placeId").toString());
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(placeId);
		//System.out.println(confirmpassword);
		return placesService.verifyFunction(placeobj) ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getters and setters
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







	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}




	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}




	public boolean acceptableParameterName(String parameterName) {
		// TODO Auto-generated method stub
		boolean accept=true;
		if(parameterName.contains("request") || parameterName.contains("session"))	{
			accept=false;
		}
		return accept;
	}




	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession = session;
	}
	

}
