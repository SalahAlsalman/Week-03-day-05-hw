package com.example.bookmanagementsoftware.controller;

import com.example.bookmanagementsoftware.DTO.ResponseAPI;
import com.example.bookmanagementsoftware.model.Book;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.model.MyUser;
import com.example.bookmanagementsoftware.service.BookService;
import com.example.bookmanagementsoftware.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getBooks() {
        return ResponseEntity.status(200).body(new ResponseAPI<>(bookService.getBooks(),200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<?>> addBook(@RequestBody @Valid Book book) {
        book.setId(-1);
        bookService.addBook(book);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Book added successfully!",201));
    }

    @PostMapping("/lendBook")
    public ResponseEntity<ResponseAPI<?>> lendBook(@RequestBody @Valid Loan loan){
        bookService.lendBook(loan);
        return ResponseEntity.status(200).body(new ResponseAPI<>("Book has been loaned!",200));
    }

    @GetMapping("/getLoansOfBook/{bookid}")
    public ResponseEntity<ResponseAPI<?>> getLoansOfBook(@PathVariable Integer bookid){
        return ResponseEntity.status(200).body(new ResponseAPI<>(bookService.getLoansOfBook(bookid),200));
    }

    
}
