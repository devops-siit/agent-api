package com.dislinkt.agentapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dislinkt.agentapi.domain.companycomment.CompanyComment;

@Repository
public interface CompanyCommentRepository extends JpaRepository<CompanyComment, Long>{

	Page<CompanyComment> findByCompanyId(Long id, Pageable pageable);

}
