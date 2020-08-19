package com.spring.reactive.loan.exception;

public class NoLoanAvailableException extends  RuntimeException{

    public NoLoanAvailableException(String no_loans_available) {
        super(no_loans_available);
    }
}
