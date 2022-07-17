package com.dislinkt.agentapi.domain.company;

import com.dislinkt.agentapi.domain.account.Account;
import com.dislinkt.agentapi.domain.base.BaseEntity;
import com.dislinkt.agentapi.domain.rate.Rate;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;

import javax.persistence.*;

@Data
@Entity
public class Company extends BaseEntity {

    @NotNull
    @Size(max = 128)
    @Column(unique = true)
    private String name;
    
    @NotNull
    @Size(max = 128)
    @Column(unique = false)
    private String address;
    
    @NotNull
    @Size(max = 25)
    @Column(unique = false)
    private String phone;
    
    @NotNull
    @Size(max = 1024)
    @Column(unique = false)
    private String description;
    
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Set<Rate> rates;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Account owner;
    
//    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
//    private Set<CompanyComment> comments;
    
    
}
