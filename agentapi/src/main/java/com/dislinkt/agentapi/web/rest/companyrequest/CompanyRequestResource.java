package com.dislinkt.agentapi.web.rest.companyrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dislinkt.agentapi.service.companyrequest.CompanyRequestService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.request.NewCompanyRequest;

@RestController
@RequestMapping("/company-request")
public class CompanyRequestResource {

	@Autowired
	private CompanyRequestService companyRequestService;
	
	
	
	@GetMapping
    public ResponseEntity<Page<CompanyRequestDTO>> findAll(Pageable pageable) {
        return ReturnResponse.entityGet(companyRequestService.findAll(pageable));
    }
	
	@GetMapping("/pending")
    public ResponseEntity<Page<CompanyRequestDTO>> findAllPending(Pageable pageable) {
        return ReturnResponse.entityGet(companyRequestService.findAllPending(pageable));
    }
	
	@PostMapping
	private ResponseEntity<CompanyRequestDTO> insertCompanyRequest(@RequestBody NewCompanyRequest companyRequest) {
		CompanyRequestDTO created = new CompanyRequestDTO();
		created = companyRequestService.insertCompanyRequest(companyRequest);
	   	return ReturnResponse.entityCreated(created);
	}
	
	@PutMapping("/approve/{requestUuid}")
	private ResponseEntity<CompanyRequestDTO> approveRequest(@PathVariable String requestUuid) {
		
		CompanyRequestDTO created = new CompanyRequestDTO();
		created = companyRequestService.approveCompanyRequest(requestUuid);
	   	return ReturnResponse.entityUpdated(created);
	}
	
	@PutMapping("/reject/{requestUuid}")
	private ResponseEntity<CompanyRequestDTO> rejectRequest(@PathVariable String requestUuid) {
		
		CompanyRequestDTO created = new CompanyRequestDTO();
		created = companyRequestService.rejectCompanyRequest(requestUuid);
	   	return ReturnResponse.entityUpdated(created);
	}
	
}
