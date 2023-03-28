package com.example.Stock_Details_Subscription_Project.repository;

import com.example.Stock_Details_Subscription_Project.model.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import  java.time.Instant;

@Repository

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    List<Subscription> findAllByEmail(String email);
    List<Subscription> findByScheduledTimeBefore(Instant now);
}
