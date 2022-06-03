package com.example.bookmanagementsoftware.service;

import com.example.bookmanagementsoftware.exceptions.BookNotFoundException;
import com.example.bookmanagementsoftware.exceptions.LoanAlreadyExistsException;
import com.example.bookmanagementsoftware.exceptions.UserNotFoundException;
import com.example.bookmanagementsoftware.model.Book;
import com.example.bookmanagementsoftware.model.Loan;
import com.example.bookmanagementsoftware.model.MyUser;
import com.example.bookmanagementsoftware.repository.BookRepository;
import com.example.bookmanagementsoftware.repository.LoanRepository;
import com.example.bookmanagementsoftware.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MyUserRepository userRepository;
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void addLoan(Loan loan) {
        if (loanRepository.findById(loan.getId()).isPresent())
            throw new LoanAlreadyExistsException("Loan is already registered!");
        userRepository.findById(loan.getUserId()).orElseThrow(() -> {
            throw new UserNotFoundException("user id is wrong!");
        });
        Book book = bookRepository.findById(loan.getBookId()).orElseThrow(()->{
            throw new BookNotFoundException("book id is wrong!");
        });
        if (book.getLoans() ==null)
            book.setLoans(new HashSet<>());
        book.getLoans().add(loan);
        if (loan.getBooks() == null)
            loan.setBooks(new HashSet<>());
        loan.getBooks().add(book);
        loanRepository.save(loan);
    }
}
