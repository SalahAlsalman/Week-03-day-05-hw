package com.example.bookmanagementsoftware.service;

import com.example.bookmanagementsoftware.exceptions.UserAlreadyRegisteredException;
import com.example.bookmanagementsoftware.model.MyUser;
import com.example.bookmanagementsoftware.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository userRepository;
    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }

    public void registerUser(MyUser user) {
        if (userRepository.findById(user.getId()).isPresent())
            throw new UserAlreadyRegisteredException("User is already registered!");
        userRepository.save(user);
    }
}
