package com.dislinkt.agentapi.domain.companycomment;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.base.BaseEntity;
import com.dislinkt.agentapi.domain.company.Company;

import lombok.Data;

@Data
@Entity
public class CompanyComment extends BaseEntity{

	@NotNull
    @Size(max = 36)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Account author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
