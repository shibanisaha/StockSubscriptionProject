package com.example.Stock_Details_Subscription_Project.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionResponse {
    private Double afterHours;
    private Double close;
    private String from;
    private Double high;
    private Double low;
    private Double open;
    private Double premarket;
    private String symbol;
    private Long value;
    private String status;




}
