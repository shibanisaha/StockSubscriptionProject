package com.example.Stock_Details_Subscription_Project.controller;

import com.example.Stock_Details_Subscription_Project.model.Subscription;
import com.example.Stock_Details_Subscription_Project.model.User;
import com.example.Stock_Details_Subscription_Project.repository.SubscriptionRepository;
import com.example.Stock_Details_Subscription_Project.repository.UserRepo;
import com.example.Stock_Details_Subscription_Project.requestDto.SubscriptionRequestDto;
import com.example.Stock_Details_Subscription_Project.service.Impl.SubscriptionServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

@Autowired
    SubscriptionServiceImpl subscriptionService;

    @PostMapping
    public String subscribeToStockTicker(@RequestBody SubscriptionRequestDto subscription, HttpServletRequest servletRequest) throws Exception{
        //getting email from authentication

       return subscriptionService.subscription(subscription, servletRequest);
    }
}
