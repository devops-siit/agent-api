package com.dislinkt.agentapi.web.rest.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dislinkt.agentapi.service.rate.RateService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.rate.payload.NewRateRequest;
import com.dislinkt.agentapi.web.rest.rate.payload.RateDTO;

@RestController
@RequestMapping("/rates")
public class RateResource {
	
	@Autowired
	private RateService rateService;

	@PostMapping
    private ResponseEntity<RateDTO> insertRate(@RequestParam String loggedAccountUuid, @RequestBody NewRateRequest rateRequest) {
    	
        return ReturnResponse.entityCreated(rateService.insertRate(loggedAccountUuid, rateRequest));
    }
	
	@GetMapping("/{companyUuid}")
    private ResponseEntity<Double> getAverageRate(@PathVariable String companyUuid) {
    	
        return new ResponseEntity<>(rateService.averageRateByCompany(companyUuid), HttpStatus.OK);
    }
}
