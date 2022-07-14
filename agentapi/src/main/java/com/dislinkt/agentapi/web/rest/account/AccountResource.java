package com.dislinkt.agentapi.web.rest.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;

@RestController
@RequestMapping("/accounts")
public class AccountResource {

	@Autowired
    private AccountService accountService;

    // only for accounts api
    @PostMapping
    private ResponseEntity<AccountDTO> insertAccount(@RequestBody AccountDTO accountDTO) {
        return ReturnResponse.entityCreated(accountService.insertAccount(accountDTO));
    }
}
