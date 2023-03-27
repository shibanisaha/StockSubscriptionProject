package com.example.Stock_Details_Subscription_Project.controller;


import com.example.Stock_Details_Subscription_Project.marketstackResponseDto.StockData;
import com.example.Stock_Details_Subscription_Project.service.Impl.StockDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock_data")
public class StockDataController {
//    start_date : string
//    - stock_symbol : string
//    - end_date : string
    @Autowired
    StockDataServiceImpl stockDataService;

@GetMapping()
        public List<StockData> getStockData(@RequestParam String symbol,
                                            @RequestParam String start_date,
                                            @RequestParam String end_date){
        return stockDataService.getStockData(symbol, start_date, end_date);
    }



}
