package com.dislinkt.agentapi.repository;

import org.springframework.stereotype.Repository;

import com.dislinkt.agentapi.domain.company.Company;
import com.dislinkt.agentapi.domain.company.request.CompanyRequest;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CompanyRequestRepository extends JpaRepository<CompanyRequest, Long> {

	Optional<CompanyRequest> findOneByUuid(String uuid);

	Page<CompanyRequest> findByRequestStatus(String status, Pageable pageable);

}
