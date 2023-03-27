package com.example.Stock_Details_Subscription_Project.marketstackResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StockData {
    private String symbol;
    private String date;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;

}
