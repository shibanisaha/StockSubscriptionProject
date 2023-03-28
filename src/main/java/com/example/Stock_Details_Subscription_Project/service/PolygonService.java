package com.example.Stock_Details_Subscription_Project.service;

import com.example.Stock_Details_Subscription_Project.responseDto.StockGetDetailsResponseDto;
import com.example.Stock_Details_Subscription_Project.responseDto.StockResponse;
import com.example.Stock_Details_Subscription_Project.responseDto.SubscriptionResponse;

import java.util.List;

public interface PolygonService {
    List<StockResponse> getStockDetails(String ticker, String startDate, String endDate);
//    SubscriptionResponse subscription(String symbol, String date);
}
