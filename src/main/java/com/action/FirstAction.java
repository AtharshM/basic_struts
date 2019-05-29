package com.action;
import org.apache.commons.lang.StringUtils;
import com.models.FirstModel;

import com.opensymphony.xwork2.ActionSupport;
import com.service.FirstService;
import com.models.FirstModel;
public class FirstAction extends ActionSupport {
	private String serviceoutput;
	private String secondoutput;
	private FirstModel model;
	
	
	
	public void validate()
	{
		if(StringUtils.isEmpty(getSecondoutput()))
		{
			addFieldError("secondoutput", "Secondoutput cannot be null");
			
		}
		
	}
	
	public String newMethod()
	{
		model = new FirstModel();
		FirstService obj = new FirstService();
		String parameter = getSecondoutput();
	   model.setSecondoutput(secondoutput);
	   if(obj.getBestCompany(model)) {
		return "zoho";}
	   else
		   return "success";
		  
		
		
		
	}
	public String getServiceoutput() {
		return serviceoutput;
	}
	public void setServiceoutput(String serviceoutput) {
		this.serviceoutput = serviceoutput;
	}
	public String getSecondoutput() {
		return secondoutput;
	}
	public void setSecondoutput(String secondoutput) {
		this.secondoutput = secondoutput;
	}

}
