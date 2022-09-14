package com.dislinkt.agentapi.domain.account;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dislinkt.agentapi.domain.base.BaseEntity;
import com.dislinkt.agentapi.domain.rate.Rate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account extends BaseEntity {

    @NotNull
    @Size(max = 36)
    @Column(unique = true)
    private String username;

    @NotNull
    @Size(max = 128)
    private String name;
}