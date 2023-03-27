package com.example.Stock_Details_Subscription_Project.service;

import com.example.Stock_Details_Subscription_Project.marketstackResponseDto.StockData;

import java.util.List;

public interface StockDataService {
    List<StockData> getStockData(String ticker, String from_data, String to_data);

}
