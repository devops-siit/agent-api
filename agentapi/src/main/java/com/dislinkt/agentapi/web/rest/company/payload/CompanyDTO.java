package com.dislinkt.agentapi.web.rest.company.payload;

import java.util.Set;

import com.dislinkt.agentapi.service.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.base.BaseDTO;
import com.dislinkt.agentapi.web.rest.rate.payload.RateDTO;

import lombok.Data;

@Data
public class CompanyDTO extends BaseDTO {

	private String name;
	
	private String address;
	
	private String phone;
	
	private String description; 
	
	private AccountDTO owner;
	
	private Set<RateDTO> rates;
}
