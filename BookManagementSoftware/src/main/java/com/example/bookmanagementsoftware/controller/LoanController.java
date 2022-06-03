package com.example.bookmanagementsoftware.controller;

import com.example.bookmanagementsoftware.DTO.ResponseAPI;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {
    private final LoanService loanService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getLoans() {
        return ResponseEntity.status(200).body(new ResponseAPI<>(loanService.getLoans(),200));
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<?>> addLoan(@RequestBody @Valid Loan loan) {
        loan.setId(-1);
        loanService.addLoan(loan);
        return ResponseEntity.status(201).body(new ResponseAPI<>("Loan added successfully!",201));
    }

    
}
