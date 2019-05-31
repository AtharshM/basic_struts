package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxAction extends ActionSupport {
	private  String place_name;
	private  String response;
	
	private static String response_holder;
	private static String place_name_holder;
	
	private String result;
	
	public void sendRequest() throws IOException
	{
		
		//changed rhs from var to method
		response_holder = getResponse();

		//changed rhs from var to method
		place_name_holder = getPlace_name();
	
		HttpServletResponse httpresponse = ServletActionContext.getResponse();
		PrintWriter out = httpresponse.getWriter();
		out.println("package_submitted");
		out.flush();
		
	}
	
	public String getResponse()
	{
		
		return result;
		
		
	}
	public String validatingResponseFromUser() {
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


}
