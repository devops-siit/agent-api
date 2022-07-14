package com.dislinkt.agentapi.web.rest.companycomment.payload;

import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.base.BaseDTO;

import lombok.Data;

@Data
public class CompanyCommentDTO extends BaseDTO  {
	
    private String text;

    private AccountDTO author;

}
