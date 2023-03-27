package com.example.Stock_Details_Subscription_Project.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockResponse {

    private Double open;
    private Double high;
    private Double low;
    private Long value;
    private Double close;




}
