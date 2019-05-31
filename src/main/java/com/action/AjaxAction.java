package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

public class AjaxAction extends ActionSupport implements SessionAware,ParameterNameAware {
	private  String place_name;
	private  String response;
	private String selectPlace;
	private static String response_holder;
	private static String place_name_holder;
	
	private String result;
	 private Map<String, Object> newSession;
	public void sendRequest() throws IOException
	{
		
		newSession.put("placeName", selectPlace);
		
		setSelectPlace(newSession.get("placeName").toString());
		System.out.println("ssssssss"+newSession.get("placeName").toString());
		
		//changed rhs from var to method
		response_holder = getResponse();

		//changed rhs from var to method
		place_name_holder = getPlace_name();

		System.out.println(getSelectPlace());
		HttpServletResponse httpresponse = ServletActionContext.getResponse();
		httpresponse.setContentType("text/plain;charset=utf-8");
		PrintWriter out = httpresponse.getWriter();
		out.println("package_submitted for the validation of admin");
		out.flush();
		
	
		
	}
	
	public String getResponse()
	{
		System.out.println(result+"9999");
		return result;
		
		
	}
	public String validatingResponseFromUser() {
		place_name_holder = getSelectPlace();
		System.out.println("sadfdsafdsfdssfff"+place_name_holder);
		if(place_name_holder == null)
		{
			return "false";
		}
		else
			return "true";
	}
	
	/**
	 * @return the place_name
	 */
	public String getPlace_name() {
		return place_name;
	}

	/**
	 * @param place_name the place_name to set
	 */
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the selectPlace
	 */
	public String getSelectPlace() {
		return selectPlace;
	}

	/**
	 * @param selectPlace the selectPlace to set
	 */
	public void setSelectPlace(String selectPlace) {
		this.selectPlace = selectPlace;
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
		this.newSession = session;
	}

}
