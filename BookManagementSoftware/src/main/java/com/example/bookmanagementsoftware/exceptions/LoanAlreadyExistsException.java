package com.example.bookmanagementsoftware.exceptions;

public class LoanAlreadyExistsException extends IllegalArgumentException{
    public LoanAlreadyExistsException(String s) {
        super(s);
    }
}
