package com.example.Stock_Details_Subscription_Project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {

    private Date timeStamp;
    private String message;
    private String details;
}
