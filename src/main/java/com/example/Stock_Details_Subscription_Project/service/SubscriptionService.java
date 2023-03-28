package com.example.Stock_Details_Subscription_Project.service;

import com.example.Stock_Details_Subscription_Project.requestDto.SubscriptionRequestDto;
import jakarta.servlet.http.HttpServletRequest;

public interface SubscriptionService {
    String subscription(SubscriptionRequestDto subscriptionRequestDto, HttpServletRequest request);
}
