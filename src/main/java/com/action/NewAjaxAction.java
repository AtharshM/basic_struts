package com.action;

import java.io.*;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewAjaxAction extends ActionSupport {

	
	
	
	public void hello() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("Hello atharsh");
		out.flush();
		
		
		
	}
}
