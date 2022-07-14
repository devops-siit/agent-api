package com.dislinkt.agentapi.web.rest.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.company.payload.CompanyDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

	@Autowired
	private CompanyService companyService;


    @PostMapping
    private ResponseEntity<CompanyDTO> insertCompany(@RequestBody CompanyRequestDTO companyRequest) {
    	CompanyDTO c = new CompanyDTO();
    	c = companyService.insertCompany(companyRequest);
    	// send request to offer-api
        return ReturnResponse.entityCreated(c);
    }
}
