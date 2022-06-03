package com.example.bookmanagementsoftware.controllerAdviceHandler;

import com.example.bookmanagementsoftware.DTO.ResponseAPI;
import com.example.bookmanagementsoftware.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class AdviceControllerHandler {
    Logger logger = LoggerFactory.getLogger(AdviceControllerHandler.class);

    @ExceptionHandler(value = UserAlreadyRegisteredException.class)
    public ResponseEntity<ResponseAPI<?>> UserAlreadyRegisteredException(UserAlreadyRegisteredException e){
        logger.info("UserAlreadyRegisteredException => provoked\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = BookAlreadyExistsException.class)
    public ResponseEntity<ResponseAPI<?>> BookAlreadyExistsException(BookAlreadyExistsException e){
        logger.info("BookAlreadyExistsException => provoked\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = LoanAlreadyExistsException.class)
    public ResponseEntity<ResponseAPI<?>> LoanAlreadyExistsException(LoanAlreadyExistsException e){
        logger.info("LoanAlreadyExistsException => provoked\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> UserNotFoundException(UserNotFoundException e){
        logger.info("UserNotFoundException => provoked\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ResponseAPI<?>> BookNotFoundException(BookNotFoundException e){
        logger.info("BookNotFoundException => provoked\n"+e.getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getMessage(),400));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseAPI<?>> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        logger.info("MethodArgumentNotValidException => provoked\n"+e.getFieldError().getDefaultMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(e.getFieldError().getDefaultMessage(),400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<ResponseAPI<?>> DataIntegrityViolationException(DataIntegrityViolationException dt){
        logger.info("DataIntegrityViolationException => provoked\n"+dt.getRootCause().getMessage());
        return ResponseEntity.status(400).body(new ResponseAPI<>(dt.getRootCause().getMessage(),400));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseAPI<?>> Exception(Exception e){
        StringWriter stringWriter=new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        logger.error("Exception => provoked\n"+stringWriter);
        return ResponseEntity.status(500).body(new ResponseAPI<>("Server error!",500));
    }


}
