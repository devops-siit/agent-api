package com.dislinkt.agentapi.domain.rate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.base.BaseEntity;
import com.dislinkt.agentapi.domain.company.Company;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueRates", columnNames = { "account_id", "company_id" }) })
public class Rate extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	
	@NotNull
	@Min(0)
	private Integer rate;

}
