package com.example.bookmanagementsoftware.exceptions;

public class UserNotFoundException extends IllegalArgumentException{
    public UserNotFoundException(String s) {
        super(s);
    }
}
