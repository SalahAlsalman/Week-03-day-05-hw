package com.example.bookmanagementsoftware.repository;

import com.example.bookmanagementsoftware.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
}
