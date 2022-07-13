package com.dislinkt.agentapi.exception.types;

import com.dislinkt.agentapi.exception.BaseException;
import org.springframework.http.HttpStatus;

public class EntityNotSavedException extends BaseException {
    private static final long serialVersionUID = 1L;

    public EntityNotSavedException(String errorMessage) {
        super(errorMessage, HttpStatus.SERVICE_UNAVAILABLE);
    }
}