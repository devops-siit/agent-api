package com.dislinkt.agentapi.web.rest.comment;

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

import com.dislinkt.agentapi.service.comment.CommentService;
import com.dislinkt.agentapi.util.ReturnResponse;
import com.dislinkt.agentapi.web.rest.comment.payload.CommentDTO;
import com.dislinkt.agentapi.web.rest.comment.payload.request.NewCommentRequest;

@RestController
@RequestMapping("/company-comment")
public class CommentResource {

	@Autowired
	private CommentService companyCommentService;
	
	@GetMapping("/{companyUuid}")
    public ResponseEntity<Page<CommentDTO>> findByPost(@PathVariable String companyUuid, Pageable pageable) {
        return ReturnResponse.entityGet(companyCommentService.findByCompany(companyUuid, pageable));
    }

    @PostMapping
    public ResponseEntity<CommentDTO> insertComment(@RequestBody NewCommentRequest commentRequest) {
        return ReturnResponse.entityGet(companyCommentService.insertComment(commentRequest));
    }
}
