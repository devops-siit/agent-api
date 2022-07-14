package com.dislinkt.agentapi.service.companycomment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.company.Company;
import com.dislinkt.agentapi.domain.companycomment.CompanyComment;
import com.dislinkt.agentapi.repository.CompanyCommentRepository;
import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.web.rest.account.payload.AccountDTO;
import com.dislinkt.agentapi.web.rest.companycomment.payload.CompanyCommentDTO;
import com.dislinkt.agentapi.web.rest.companycomment.payload.request.NewCommentRequest;

@Service
public class CompanyCommentService {

	@Autowired
	private CompanyCommentRepository repository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CompanyService companyService;
	
	
	public Page<CompanyCommentDTO> findByCompany(String companyUuid, Pageable pageable) {

		Company company = companyService.findOneByUuidOrElseThrowException(companyUuid);
		
        Page<CompanyComment> comments = repository.findByCompanyId(company.getId(), pageable);

        return comments.map(comment -> {
            CompanyCommentDTO dto = new CompanyCommentDTO();

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
	
	public CompanyCommentDTO insertComment(String loggedAccountUuid, NewCommentRequest commentRequest) {

        Company company = companyService.findOneByUuidOrElseThrowException(commentRequest.getCompanyUuid());

        Account account = accountService.findOneByUuidOrElseThrowException(loggedAccountUuid);

        CompanyComment comment = new CompanyComment();

        comment.setText(commentRequest.getText());
        comment.setCompany(company);;
        comment.setAuthor(account);

        repository.save(comment);

        CompanyCommentDTO dto = new CompanyCommentDTO();

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
