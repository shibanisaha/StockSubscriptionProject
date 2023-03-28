package com.example.Stock_Details_Subscription_Project.service;

import com.example.Stock_Details_Subscription_Project.requestDto.LoginRequestDto;
import com.example.Stock_Details_Subscription_Project.requestDto.UserRequestDto;

public interface UserService {
    String register(UserRequestDto userRequestDto) throws Exception;
    Object login(LoginRequestDto loginRequestDto)throws Exception;
}
