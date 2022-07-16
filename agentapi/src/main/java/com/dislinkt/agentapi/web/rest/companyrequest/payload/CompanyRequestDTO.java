package com.dislinkt.agentapi.web.rest.companyrequest.payload;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.base.BaseDTO;

import lombok.Data;

@Data
public class CompanyRequestDTO extends BaseDTO {

	private String name;
	
	private String address;
	
	private String phone;
	
	private String description; 
	
	private String requestStatus;
	
	private AccountDTO owner;
	
}
