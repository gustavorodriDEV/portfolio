package com.gustavo.portfolio.backend.exceptions;

public class AdminNotFoundException extends RuntimeException {

    public AdminNotFoundException(String msg){
        super(msg);
    }
}
