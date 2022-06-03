package com.example.bookmanagementsoftware.controller;

import com.example.bookmanagementsoftware.DTO.ResponseAPI;
import com.example.bookmanagementsoftware.model.MyUser;
import com.example.bookmanagementsoftware.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final MyUserService userService;

    @GetMapping
    public ResponseEntity<ResponseAPI<?>> getUsers() {
        return ResponseEntity.status(200).body(new ResponseAPI<>(userService.getUsers(),200));
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseAPI<?>> register(@RequestBody @Valid MyUser user) {
        user.setId(-1);
        userService.registerUser(user);
        return ResponseEntity.status(201).body(new ResponseAPI<>("User Registered Successfully!",201));
    }


}
