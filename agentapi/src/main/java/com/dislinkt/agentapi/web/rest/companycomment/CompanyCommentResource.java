package com.dislinkt.agentapi.web.rest.companycomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dislinkt.agentapi.service.companycomment.CompanyCommentService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.companycomment.payload.CompanyCommentDTO;
import com.dislinkt.agentapi.web.rest.companycomment.payload.request.NewCommentRequest;

@RestController
@RequestMapping("/company-comment")
public class CompanyCommentResource {

	@Autowired
	private CompanyCommentService companyCommentService;
	
	@GetMapping("/{companyUuid}")
    public ResponseEntity<Page<CompanyCommentDTO>> findByPost(@PathVariable String companyUuid, Pageable pageable) {
        return ReturnResponse.entityGet(companyCommentService.findByCompany(companyUuid, pageable));
    }

    @PostMapping
    public ResponseEntity<CompanyCommentDTO> insertComment(@RequestParam String loggedAccountUuid,
                                                    @RequestBody NewCommentRequest commentRequest) {
        return ReturnResponse.entityGet(companyCommentService.insertComment(loggedAccountUuid, commentRequest));
    }
}
