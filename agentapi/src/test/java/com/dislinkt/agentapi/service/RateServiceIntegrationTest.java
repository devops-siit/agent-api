package com.dislinkt.agentapi.service;

import static com.dislinkt.agentapi.constants.AccountConstants.DB_ACCOUNT_USERNAME_1;
import static com.dislinkt.agentapi.constants.RateConstants.ALREADY_RATE_COMPANY_UUID;
import static com.dislinkt.agentapi.constants.RateConstants.NEW_RATE_COMPANY_UUID;
import static com.dislinkt.agentapi.constants.RateConstants.NEW_RATE_RATE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.dislinkt.agentapi.service.rate.RateService;
import com.dislinkt.agentapi.web.rest.rate.payload.NewRateRequest;
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestExecutionListeners(
	    listeners = {TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class},
	    inheritListeners = false
	    
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RateServiceIntegrationTest {
	
	@Autowired
	private RateService service;

	@BeforeAll
	public void init() {
		Authentication authentication = Mockito.mock(Authentication.class);
		SecurityContext securityContext = Mockito.mock(SecurityContext.class);
		Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
		SecurityContextHolder.setContext(securityContext);
	
		Set<? extends GrantedAuthority> auth = new HashSet<>(); 
		UserDetails principal = new User(DB_ACCOUNT_USERNAME_1, "aPassword", auth);
		Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(principal);	
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInsertRate() {
		NewRateRequest req = new NewRateRequest();
		req.setCompanyUuid(NEW_RATE_COMPANY_UUID);
		req.setRate(NEW_RATE_RATE);
		
		//RateDTO rate = service.insertRate(req);
		//assertEquals(NEW_RATE_RATE, req.getRate());
	}
	
	@Test
	@Transactional
	public void testInsertRateException() {
		NewRateRequest req = new NewRateRequest();
		req.setCompanyUuid(ALREADY_RATE_COMPANY_UUID);
		req.setRate(NEW_RATE_RATE);
		
		Throwable exception = assertThrows(
				Exception.class, () -> {
	        		service.insertRate(req);
	        		//service.insertRate(req);
	            }
	    );
	    assertEquals("You alredy rate this company", exception.getMessage());
		
	}
	
	@Test
	@Transactional
	public void testAverageRateByCompany() {
		double averageRate = service.averageRateByCompany(ALREADY_RATE_COMPANY_UUID);
		
		assertEquals(10, averageRate);
	}
}
