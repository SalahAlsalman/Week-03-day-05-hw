package com.example.bookmanagementsoftware.service;

import com.example.bookmanagementsoftware.exceptions.BookAlreadyExistsException;
import com.example.bookmanagementsoftware.exceptions.BookNotFoundException;
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
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final MyUserRepository userRepository;
    private final LoanRepository loanRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        if (bookRepository.findById(book.getId()).isPresent())
            throw new BookAlreadyExistsException("Book is already registered!");
        bookRepository.save(book);
    }

    public void lendBook(Loan loan) {
        MyUser user = userRepository.findById(loan.getUserId()).orElseThrow(()->{
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

    public Set<Loan> getLoansOfBook(Integer bookid) {
        Book book = bookRepository.findById(bookid).orElseThrow(()->{
            throw new BookNotFoundException("book id is wrong!");
        });
        return book.getLoans();
    }
}
