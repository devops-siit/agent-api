package com.dislinkt.agentapi.domain.companyrequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.base.BaseEntity;

import lombok.Data;

@Data
@Entity
public class CompanyRequest extends BaseEntity {

	@NotNull
    @Size(max = 128)
    @Column(unique = true)
    private String name;
    
    @NotNull
    @Size(max = 128)
    @Column(unique = false)
    private String address;
    
    @NotNull
    @Size(max = 128)
    @Column(unique = false)
    private String phone;
    
    @NotNull
    @Size(max = 1024)
    @Column(unique = false)
    private String description;
    
    @NotNull
    @Size(max = 128)
    @Column(unique = true)
    private String requestStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Account owner;
    
}
