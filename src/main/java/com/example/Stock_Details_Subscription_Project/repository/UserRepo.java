package com.example.Stock_Details_Subscription_Project.repository;

import com.example.Stock_Details_Subscription_Project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String>{

    User findByEmail(String email);


}
