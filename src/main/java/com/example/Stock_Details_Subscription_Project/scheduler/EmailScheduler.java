package com.example.Stock_Details_Subscription_Project.scheduler;

import com.example.Stock_Details_Subscription_Project.model.Subscription;
import com.example.Stock_Details_Subscription_Project.repository.SubscriptionRepository;
import com.example.Stock_Details_Subscription_Project.service.Impl.EmailServiceImpl;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmailScheduler {

    @Autowired
    EmailServiceImpl emailService;
    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Scheduled(fixedDelay = 60000)
    public void sendScheduledMail(){
        Instant now = Instant.now();
        List<Subscription> subscriptionList = subscriptionRepository.findByScheduledTimeBefore(now);

        for(Subscription subscription: subscriptionList){
            //send email
            emailService.sendSubscriptionEmail(subscription);
            subscription.setScheduledTime(now.plus(Duration.ofDays(subscription.getIntervalDays())));
            subscription.setLastSentDay(LocalDate.now());
            subscriptionRepository.save(subscription);
        }

    }
}
