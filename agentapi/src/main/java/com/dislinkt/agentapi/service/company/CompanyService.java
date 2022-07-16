package com.dislinkt.agentapi.service.company;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.company.Company;
import com.dislinkt.agentapi.exception.types.EntityAlreadyExistsException;
import com.dislinkt.agentapi.exception.types.EntityNotFoundException;
import com.dislinkt.agentapi.repository.CompanyRepository;
import com.dislinkt.agentapi.service.account.AccountService;
import com.dislinkt.agentapi.web.rest.company.payload.CompanyDTO;
import com.dislinkt.agentapi.web.rest.companyrequest.payload.CompanyRequestDTO;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AccountService accountService;
	
	public CompanyDTO insertCompany(CompanyRequestDTO reqDTO) {

        Optional<Company> companyOrEmpty = companyRepository.findOneByName(reqDTO.getName());

        if (companyOrEmpty.isPresent()) {
            throw new EntityAlreadyExistsException("Company already exists");
        }

        Company company = new Company();
        Account account = accountService.findOneByUuidOrElseThrowException(reqDTO.getOwner().getUuid());
        
        company.setName(reqDTO.getName());
        company.setAddress(reqDTO.getAddress());
        company.setPhone(reqDTO.getPhone());
        company.setDescription(reqDTO.getDescription());
        company.setOwner(account);

		companyRepository.save(company);
		CompanyDTO dto = new CompanyDTO();
		dto.setName(reqDTO.getName());
		dto.setAddress(reqDTO.getAddress());
		dto.setDescription(reqDTO.getDescription());
		dto.setPhone(reqDTO.getPhone());
		dto.setOwner(reqDTO.getOwner());

        dto.setUuid(company.getUuid());

        return dto;
    }

    public Company findOneByUuidOrElseThrowException(String uuid) {
        return companyRepository.findOneByUuid(uuid).orElseThrow(() ->
                new EntityNotFoundException("Company not found"));
    }
	
}
