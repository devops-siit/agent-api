package com.dislinkt.agentapi.web.rest.company.payload;

import com.dislinkt.agentapi.web.rest.base.BaseDTO;

import lombok.Data;

@Data
public class SimpleCompanyDTO extends BaseDTO{

	private String name;
    
    private String address;
	
	private String phone;
	
	private String description; 
}
