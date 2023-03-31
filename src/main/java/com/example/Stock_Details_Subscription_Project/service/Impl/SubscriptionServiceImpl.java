package com.example.Stock_Details_Subscription_Project.service.Impl;

import com.example.Stock_Details_Subscription_Project.Enum.NotificationFrequency;
import com.example.Stock_Details_Subscription_Project.exception.APIException;
import com.example.Stock_Details_Subscription_Project.model.Subscription;
import com.example.Stock_Details_Subscription_Project.repository.SubscriptionRepository;
import com.example.Stock_Details_Subscription_Project.requestDto.SubscriptionRequestDto;
import com.example.Stock_Details_Subscription_Project.service.SubscriptionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import java.nio.file.AccessDeniedException;
import java.time.*;
import java.util.List;
import java.time.format.DateTimeFormatter;



@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Override
    public String subscription(SubscriptionRequestDto subscription, HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();


        List<Subscription> allSubscription = subscriptionRepository.findAllByEmail(email);

        Subscription existingSUbscription = allSubscription
                .stream().filter(subscription1 -> subscription1.getStockSymbol().equals(subscription.getStockSymbol()))
                .findFirst()
                .orElse(null);


        if(existingSUbscription != null){
            throw new APIException(HttpStatus.BAD_REQUEST, "Subscription for the ticker already exists");
        }

        //convert string time to UTC
        LocalTime localTime = LocalTime.parse(subscription.getNotifyTime());
        ZoneOffset utcOffset = OffsetDateTime.now().getOffset();
        OffsetDateTime utcDateTime = OffsetDateTime.of(LocalDate.now(), localTime, utcOffset);
        Instant utcInstant = utcDateTime.toInstant();

        int interval = 0;
        if(subscription.getNotificationFrequency().equals(NotificationFrequency.DAILY)){
            interval = 1;
        }else if(subscription.getNotificationFrequency().equals(NotificationFrequency.WEEKLY)){
            interval = 7;
        } else if (subscription.getNotificationFrequency().equals(NotificationFrequency.BIWEEKLY)) {
            interval = 14;
        }else{
            interval = 30;
        }

        Subscription currSubscription = Subscription.builder()
                .email(email).scheduledTime(utcInstant)
                .stockSymbol(subscription.getStockSymbol())
                .intervalDays(interval)
                .build();
        subscriptionRepository.save(currSubscription);

        return "Subscription added successfully";
    }
}
