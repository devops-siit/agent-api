package com.dislinkt.agentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dislinkt.agentapi.domain.rate.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long>{

	Optional<Rate> findOneByAccountIdAndCompanyId(Long accountId, Long companyId);
}
