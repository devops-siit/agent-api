package com.dislinkt.agentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dislinkt.agentapi.domain.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	Optional<Company> findOneByName(String name);

    Optional<Company> findOneByUuid(String uuid);
}
