package com.dislinkt.agentapi.web.rest.comment.payload;

import com.dislinkt.agentapi.service.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.base.BaseDTO;

import lombok.Data;

@Data
public class CommentDTO extends BaseDTO  {
	
    private String text;

    private AccountDTO author;

}
