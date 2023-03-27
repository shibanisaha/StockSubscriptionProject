package com.example.Stock_Details_Subscription_Project.service.Impl;


import com.example.Stock_Details_Subscription_Project.marketstackResponseDto.StockData;
import com.example.Stock_Details_Subscription_Project.marketstackResponseDto.StockDataResponse;
import com.example.Stock_Details_Subscription_Project.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StockDataServiceImpl implements StockDataService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<StockData> getStockData(String symbol, String fromDate , String toDate) {
        String url = "https://api.marketstack.com/v1/eod?access_key=9f278433049e7c9430f6153683b5addf&symbols=" + symbol
                + "&date_from=" + fromDate + "&date_to=" + toDate;
        StockDataResponse response = restTemplate.getForObject(url, StockDataResponse.class);
        return response.getResult();
    }
}
