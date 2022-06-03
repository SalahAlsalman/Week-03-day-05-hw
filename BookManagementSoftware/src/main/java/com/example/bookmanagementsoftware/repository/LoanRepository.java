package com.example.bookmanagementsoftware.repository;

import com.example.bookmanagementsoftware.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
