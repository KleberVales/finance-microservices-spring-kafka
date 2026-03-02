package com.finance.userservice.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String emailAlreadyRegistered) {
        super(emailAlreadyRegistered);
    }
}
