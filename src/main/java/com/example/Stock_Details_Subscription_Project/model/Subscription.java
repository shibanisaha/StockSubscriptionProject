package com.example.Stock_Details_Subscription_Project.model;

import com.example.Stock_Details_Subscription_Project.Enum.NotificationFrequency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(value = "subscription")
public class Subscription {

    @Id
    private String id;
    private String email;
    private  String stockSymbol;
    private Instant scheduledTime;
    private int intervalDays;
    private LocalDate lastSentDay;

}
