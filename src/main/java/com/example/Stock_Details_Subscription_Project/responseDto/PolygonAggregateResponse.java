package com.example.Stock_Details_Subscription_Project.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class PolygonAggregateResponse {
    private List<StockGetDetailsResponseDto> results;
}
