package com.dislinkt.agentapi.service.companyrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.company.request.CompanyRequest;
import com.dislinkt.agentapi.exception.types.EntityNotFoundException;
import com.dislinkt.agentapi.repository.CompanyRequestRepository;
import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.service.account.payload.AccountDTO;
import com.dislinkt.agentapi.service.company.CompanyService;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.request.NewCompanyRequest;

@Service
public class CompanyRequestService {

	@Autowired
	private CompanyRequestRepository repository;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AccountService accountService;
	
	public CompanyRequest findOneByUuidOrElseThrowException(String uuid) {
        return repository.findOneByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Company request not found"));
    }
	
	public CompanyRequestDTO insertCompanyRequest(NewCompanyRequest req) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Account account = accountService.findOneByUsernameOrElseThrowException(user.getUsername());
		
		CompanyRequest newReq = new CompanyRequest();
		newReq.setName(req.getName());
		newReq.setAddress(req.getAddress());
		newReq.setPhone(req.getPhone());
		newReq.setDescription(req.getDescription());
		newReq.setOwner(account);
		newReq.setRequestStatus("PENDING");
		// set owner
		
		repository.save(newReq);
		CompanyRequestDTO reqDTO = new CompanyRequestDTO();
		reqDTO.setName(newReq.getName());
		reqDTO.setAddress(newReq.getAddress());
		reqDTO.setDescription(newReq.getDescription());
		reqDTO.setPhone(newReq.getPhone());
		reqDTO.setRequestStatus(newReq.getRequestStatus());
		reqDTO.setUuid(newReq.getUuid());
		AccountDTO acc = new AccountDTO();
		acc.setName(newReq.getOwner().getName());
		acc.setUsername(newReq.getOwner().getUsername());
		acc.setUuid(newReq.getOwner().getUuid());
		reqDTO.setOwner(acc);
		
		
		return reqDTO;
	}
	
	public CompanyRequestDTO approveCompanyRequest(String companyRequestUuid) {
		
		CompanyRequest req = findOneByUuidOrElseThrowException(companyRequestUuid);
		req.setRequestStatus("APPROVED");
		
		repository.save(req);
		
		
		CompanyRequestDTO reqDTO = new CompanyRequestDTO();
		reqDTO.setName(req.getName());
		reqDTO.setAddress(req.getAddress());
		reqDTO.setDescription(req.getDescription());
		reqDTO.setPhone(req.getPhone());
		reqDTO.setRequestStatus(req.getRequestStatus());
		reqDTO.setUuid(req.getUuid());

		AccountDTO acc = new AccountDTO();
		acc.setName(req.getOwner().getName());
		acc.setUsername(req.getOwner().getUsername());
		acc.setUuid(req.getOwner().getUuid());
		reqDTO.setOwner(acc);
		companyService.insertCompany(reqDTO);
		
		return reqDTO;
	}
	
	public CompanyRequestDTO rejectCompanyRequest(String companyRequestUuid) {
		
		CompanyRequest req = findOneByUuidOrElseThrowException(companyRequestUuid);
		req.setRequestStatus("REJECTED");
		
		repository.save(req);
		
		CompanyRequestDTO reqDTO = new CompanyRequestDTO();
		reqDTO.setName(req.getName());
		reqDTO.setAddress(req.getAddress());
		reqDTO.setDescription(req.getDescription());
		reqDTO.setPhone(req.getPhone());
		reqDTO.setRequestStatus(req.getRequestStatus());
		reqDTO.setUuid(req.getUuid());

		AccountDTO acc = new AccountDTO();
		acc.setName(req.getOwner().getName());
		acc.setUsername(req.getOwner().getUsername());
		acc.setUuid(req.getOwner().getUuid());
		reqDTO.setOwner(acc);
		
		return reqDTO;
	}

	public Page<CompanyRequestDTO> findAll(Pageable pageable) {
		
		Page<CompanyRequest> requests = repository.findAll(pageable);

        
		return requests.map(req -> {
            CompanyRequestDTO reqDTO = new CompanyRequestDTO();
            reqDTO.setUuid(req.getUuid());
            reqDTO.setDescription(req.getDescription());
            reqDTO.setName(req.getName());
            reqDTO.setAddress(req.getAddress());
            reqDTO.setPhone(req.getPhone());
            reqDTO.setRequestStatus(req.getRequestStatus());
            

            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUuid(req.getOwner().getUuid());
            accountDTO.setName(req.getOwner().getName());
            accountDTO.setUsername(req.getOwner().getUsername());

            reqDTO.setOwner(accountDTO);

            return reqDTO;
        });
	}
	
	
	public Page<CompanyRequestDTO> findAllPending(Pageable pageable) {
		
		Page<CompanyRequest> requests = repository.findByRequestStatus("PENDING", pageable);
        
		return requests.map(req -> {
            CompanyRequestDTO reqDTO = new CompanyRequestDTO();
            reqDTO.setUuid(req.getUuid());
            reqDTO.setDescription(req.getDescription());
            reqDTO.setName(req.getName());
            reqDTO.setAddress(req.getAddress());
            reqDTO.setPhone(req.getPhone());
            reqDTO.setRequestStatus(req.getRequestStatus());
            

            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setUuid(req.getOwner().getUuid());
            accountDTO.setName(req.getOwner().getName());
            accountDTO.setUsername(req.getOwner().getUsername());

            reqDTO.setOwner(accountDTO);

            return reqDTO;
        });
	}
	
}
