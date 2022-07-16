package com.dislinkt.agentapi.web.rest.rate.payload;

import lombok.Data;

@Data
public class NewRateRequest {

	private String companyUuid;
	private Integer rate;
}
