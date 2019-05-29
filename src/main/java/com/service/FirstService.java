package com.service;
import com.models.FirstModel;

public class FirstService {
	
	public boolean getBestCompany(FirstModel parameter)
	{
		if(parameter.getSecondoutput().equals("zoho"))
		{
		return true;
		}
		else
			return false;
	}

}
