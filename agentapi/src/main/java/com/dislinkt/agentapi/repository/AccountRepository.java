package com.dislinkt.agentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dislinkt.agentapi.domain.account.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findOneByUsername(String username);

	Optional<Account> findOneByUuid(String uuid);

}
