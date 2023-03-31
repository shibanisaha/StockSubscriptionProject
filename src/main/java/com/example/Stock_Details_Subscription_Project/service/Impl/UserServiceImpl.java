package com.example.Stock_Details_Subscription_Project.service.Impl;


import com.example.Stock_Details_Subscription_Project.exception.APIException;
import com.example.Stock_Details_Subscription_Project.model.User;
import com.example.Stock_Details_Subscription_Project.repository.UserRepo;
import com.example.Stock_Details_Subscription_Project.requestDto.LoginRequestDto;
import com.example.Stock_Details_Subscription_Project.requestDto.UserRequestDto;
import com.example.Stock_Details_Subscription_Project.security.JwtTokenProvider;
import com.example.Stock_Details_Subscription_Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public String register(UserRequestDto userRequestDto) throws Exception{

        User user = userRepo.findByEmail(userRequestDto.getEmail());
        if (user != null){
            throw new APIException(HttpStatus.BAD_REQUEST, "User already exists with the given email");
        }


     user = User.builder().id(userRequestDto.getId())
                .first_name(userRequestDto.getFirst_name())
                .last_name(userRequestDto.getLast_name())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .phone_number(userRequestDto.getPhone_number())
                .build();
        userRepo.save(user);
        return "User registered successfully";
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) throws Exception {
      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),
                loginRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        return token;
    }

}
