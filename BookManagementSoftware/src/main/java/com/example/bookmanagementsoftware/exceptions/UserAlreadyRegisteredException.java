package com.example.bookmanagementsoftware.exceptions;

public class UserAlreadyRegisteredException extends IllegalArgumentException{
    public UserAlreadyRegisteredException(String s) {
        super(s);
    }
}
