package com.example.Stock_Details_Subscription_Project.service;

import com.example.Stock_Details_Subscription_Project.model.Subscription;

public interface EmailService {
    void sendSubscriptionEmail(Subscription subscription);
}
