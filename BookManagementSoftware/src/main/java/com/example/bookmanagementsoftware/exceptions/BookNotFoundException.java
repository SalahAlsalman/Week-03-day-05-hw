package com.example.bookmanagementsoftware.exceptions;

public class BookNotFoundException extends IllegalArgumentException{

    public BookNotFoundException(String s) {
        super(s);
    }
}
