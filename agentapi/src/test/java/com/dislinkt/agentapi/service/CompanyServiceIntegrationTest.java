package com.dislinkt.agentapi.service;

import static com.dislinkt.agentapi.constants.CompanyConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.dislinkt.agentapi.domain.company.Company;
import com.dislinkt.agentapi.event.CompanyRegistrationSource;
import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.company.payload.CompanyDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.CompanyRequestResource;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestExecutionListeners(
	    listeners = {TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class},
	    inheritListeners = false
	    
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CompanyServiceIntegrationTest {

	@Autowired
	@InjectMocks
	private CompanyService service;
	
	@Mock
	private CompanyRegistrationSource companyRegistrationSource;
	
	@BeforeAll
	public void initMocks() {

		MockitoAnnotations.initMocks(this);
		Mockito.when(companyRegistrationSource.companyRegistration()).thenReturn(new MessageChannel() {
			
			@Override
			public boolean send(Message<?> message, long timeout) {
				
				return false;
			}
		}); 
	}
	
	@Test
	public void testInsertCompany() {
		CompanyRequestDTO req = new CompanyRequestDTO();
		req.setAddress(DB_REQUEST_ADDRESS);
		req.setDescription(DB_REQUEST_DESC);
		req.setName(DB_REQUEST_NAME);
		req.setPhone(DB_REQUEST_PHONE);
		req.setRequestStatus(DB_REQUEST_STATUS);
		req.setUuid(DB_REQUEST_UUID);
		AccountDTO acc = new AccountDTO();
		acc.setUuid(DB_REQUEST_OWNER_UUID);
		req.setOwner(acc);
		
		CompanyDTO dto = service.insertCompany(req);
		assertEquals(DB_REQUEST_NAME, dto.getName());
	}
	
	@Test
	public void testInsertCompanyAlreadyExists() {
		CompanyRequestDTO req = new CompanyRequestDTO();
		req.setName(DB_COMPANY_NAME);
		Throwable exception = assertThrows(
				Exception.class, () -> {
	        		service.insertCompany(req);
	            }
	    );
	    assertEquals("Company already exists", exception.getMessage());
		
	}
	
	@Test
	public void testFindOne() {
		Company company = service.findOneByUuidOrElseThrowException(DB_COMPANY_UUID);
		assertEquals(DB_COMPANY_NAME, company.getName());
	}
	
	@Test
	public void testFindOneThrowException() {
		Throwable exception = assertThrows(
				Exception.class, () -> {
	        		service.findOneByUuidOrElseThrowException(COMPANY_UUID_DoesntExist);
	            }
	    );
	    assertEquals("Company not found", exception.getMessage());
		
	}
}
