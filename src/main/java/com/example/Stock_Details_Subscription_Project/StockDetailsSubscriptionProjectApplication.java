package com.example.Stock_Details_Subscription_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockDetailsSubscriptionProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(StockDetailsSubscriptionProjectApplication.class, "--debug");
	}

}
