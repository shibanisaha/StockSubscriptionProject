package com.example.Stock_Details_Subscription_Project.controller;


import com.example.Stock_Details_Subscription_Project.responseDto.StockGetDetailsResponseDto;
import com.example.Stock_Details_Subscription_Project.responseDto.StockResponse;
import com.example.Stock_Details_Subscription_Project.service.Impl.PolygonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock_details")
public class PolygonController {

    @Autowired
    PolygonServiceImpl polygonService;

    @GetMapping
    public List<StockResponse> getStockDetails(@RequestParam String ticker,@RequestParam String startDate,@RequestParam String endDate){
       return polygonService.getStockDetails(ticker, startDate, endDate);
    }

}
