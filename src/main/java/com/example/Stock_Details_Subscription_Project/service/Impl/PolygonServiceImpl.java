package com.example.Stock_Details_Subscription_Project.service.Impl;


import com.example.Stock_Details_Subscription_Project.responseDto.PolygonAggregateResponse;
import com.example.Stock_Details_Subscription_Project.responseDto.StockGetDetailsResponseDto;
import com.example.Stock_Details_Subscription_Project.responseDto.StockResponse;
import com.example.Stock_Details_Subscription_Project.service.PolygonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolygonServiceImpl implements PolygonService {
    @Autowired
    RestTemplate restTemplate;
    @Override
    public List<StockResponse> getStockDetails(String ticker, String startDate, String endDate) {
        String url = String.format(
                "https://api.polygon.io/v2/aggs/ticker/%s/range/1/day/%s/%s?apiKey=FioOlpcc0vi1wF_9uxcqNEdb2bwaTmKx&adjusted=true", ticker, startDate, endDate
        );

        PolygonAggregateResponse response = restTemplate.getForObject(url, PolygonAggregateResponse.class);


        List<StockResponse> result = new ArrayList<>();
        List<StockGetDetailsResponseDto> ApiResult = response.getResults();
        for(StockGetDetailsResponseDto st: ApiResult){
            StockResponse stockResponse = StockResponse.builder()
                    .low(st.getL())
                    .high(st.getH())
                    .open(st.getO())
                    .close(st.getC())
                    .value(st.getV())
                    .build();
            result.add(stockResponse);

        }


        return result;
    }
}
