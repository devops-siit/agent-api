package com.dislinkt.agentapi.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.dislinkt.agentapi.constants.AccountConstants.*;

import com.dislinkt.agentapi.event.AccountCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.service.account.payload.AccountDTO;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestExecutionListeners(
	    listeners = {TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class},
	    inheritListeners = false
	    
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AccountServiceIntegrationTest {
	
	@Autowired
	private AccountService service;
	
	@Test
	public void testFindByUuid() throws Exception {
		
		Account foundAccount = service.findOneByUuidOrElseThrowException(DB_ACCOUNT_UUID_2);
		
		assertEquals(DB_ACCOUNT_ID_2, foundAccount.getId()); 
    }
	

	@Test
	@Transactional
	@Rollback(true)
	public void testInsertAccount() throws Exception {
		
//		AccountCreatedEvent event = new AccountCreatedEvent();
//		event.setName(NEW_ACCOUNT_NAME);
//		
//		event.setUsername(NEW_ACCOUNT_USERNAME);
//		event.setUuid(NEW_ACCOUNT_UUID);
//		service.insertAccount(event);
//		
//		Account acc = service.findOneByUuidOrElseThrowException(NEW_ACCOUNT_UUID);
//		assertEquals(acc.getUuid(), event.getUuid());
		
		AccountCreatedEvent dto = new AccountCreatedEvent();
		dto.setName(NEW_ACCOUNT_NAME);
		dto.setUsername(NEW_ACCOUNT_USERNAME);
		dto.setUuid(NEW_ACCOUNT_UUID);
		
		service.insertAccount(dto);
    }
	
	
}
