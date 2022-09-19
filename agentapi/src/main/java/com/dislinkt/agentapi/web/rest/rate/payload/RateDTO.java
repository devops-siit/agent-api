package com.dislinkt.agentapi.web.rest.rate.payload;

import com.dislinkt.agentapi.service.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.base.BaseDTO;
import com.dislinkt.agentapi.web.rest.company.payload.CompanyDTO;

import lombok.Data;

@Data
public class RateDTO extends BaseDTO{

	private AccountDTO account;
	private CompanyDTO company;
	private Integer rate;
}
