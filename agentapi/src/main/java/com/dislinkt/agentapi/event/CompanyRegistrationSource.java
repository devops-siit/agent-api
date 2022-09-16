package com.dislinkt.agentapi.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CompanyRegistrationSource {

    @Output("companyRegistrationChannel")
    MessageChannel companyRegistration();
}