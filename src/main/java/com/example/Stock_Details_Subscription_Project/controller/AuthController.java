package com.example.Stock_Details_Subscription_Project.controller;


import com.example.Stock_Details_Subscription_Project.requestDto.LoginRequestDto;
import com.example.Stock_Details_Subscription_Project.requestDto.UserRequestDto;
import com.example.Stock_Details_Subscription_Project.service.Impl.UserServiceImpl;
import com.example.Stock_Details_Subscription_Project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
@Autowired
UserService userService;



    @PostMapping("/register")
        public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) throws Exception{
        return new ResponseEntity<>(userService.register(userRequestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto) throws Exception{

        return new ResponseEntity<>(userService.login(loginRequestDto), HttpStatus.OK);
    }
}
