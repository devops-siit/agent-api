package com.dislinkt.agentapi.web.rest.companycomment.payload.request;

import lombok.Data;

@Data
public class NewCommentRequest {

	private String text;
	
	private String companyUuid;
}
