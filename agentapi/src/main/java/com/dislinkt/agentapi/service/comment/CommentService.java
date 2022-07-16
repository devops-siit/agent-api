package com.dislinkt.agentapi.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.company.Company;
import com.dislinkt.agentapi.domain.company.comment.Comment;
import com.dislinkt.agentapi.repository.CommentRepository;
import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.comment.payload.CommentDTO;
import com.dislinkt.agentapi.web.rest.comment.payload.request.NewCommentRequest;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CompanyService companyService;
	
	
	public Page<CommentDTO> findByCompany(String companyUuid, Pageable pageable) {

		Company company = companyService.findOneByUuidOrElseThrowException(companyUuid);
		
        Page<Comment> comments = repository.findByCompanyId(company.getId(), pageable);

        return comments.map(comment -> {
            CommentDTO dto = new CommentDTO();

            dto.setText(comment.getText());
            dto.setUuid(comment.getUuid());

            AccountDTO author = new AccountDTO();
            author.setUuid(comment.getAuthor().getUuid());
            author.setName(comment.getAuthor().getName());
            author.setUsername(comment.getAuthor().getUsername());

            dto.setAuthor(author);

            return dto;
        });
    }
	
	public CommentDTO insertComment(String loggedAccountUuid, NewCommentRequest commentRequest) {

        Company company = companyService.findOneByUuidOrElseThrowException(commentRequest.getCompanyUuid());

        Account account = accountService.findOneByUuidOrElseThrowException(loggedAccountUuid);

        Comment comment = new Comment();

        comment.setText(commentRequest.getText());
        comment.setCompany(company);;
        comment.setAuthor(account);

        repository.save(comment);

        CommentDTO dto = new CommentDTO();

        dto.setText(comment.getText());
        dto.setUuid(comment.getUuid());

        AccountDTO author = new AccountDTO();
        author.setUuid(comment.getAuthor().getUuid());
        author.setName(comment.getAuthor().getName());
        author.setUsername(comment.getAuthor().getUsername());

        dto.setAuthor(author);

        return dto;
    }
}
