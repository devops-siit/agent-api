package com.dislinkt.agentapi.web.rest.companyrequest.payload.request;

import lombok.Data;

@Data
public class NewCompanyRequest {

	private String name;
	
	private String address;
	
	private String phone;
	
	private String description; 
}
