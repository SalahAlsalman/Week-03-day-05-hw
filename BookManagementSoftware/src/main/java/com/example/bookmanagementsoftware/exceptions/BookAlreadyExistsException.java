package com.example.bookmanagementsoftware.exceptions;

public class BookAlreadyExistsException extends IllegalArgumentException{
    public BookAlreadyExistsException(String s) {
        super(s);
    }
}
