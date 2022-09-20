package com.dislinkt.agentapi.web.rest.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.company.payload.CompanyDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

	@Autowired
	private CompanyService companyService;

    @GetMapping
    private ResponseEntity<Page<CompanyDTO>> findAll(Pageable pageable) {
        return ReturnResponse.entityGet(companyService.findAll(pageable));
    }

    @PostMapping
    private ResponseEntity<CompanyDTO> insertCompany(@RequestBody CompanyRequestDTO companyRequest) {
    	CompanyDTO c = new CompanyDTO();
    	c = companyService.insertCompany(companyRequest);
    	// send request to offer-api
        return ReturnResponse.entityCreated(c);
    }
}
