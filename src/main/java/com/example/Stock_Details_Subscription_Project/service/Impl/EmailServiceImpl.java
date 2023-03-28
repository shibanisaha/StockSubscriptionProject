package com.example.Stock_Details_Subscription_Project.service.Impl;

import com.example.Stock_Details_Subscription_Project.model.Subscription;
import com.example.Stock_Details_Subscription_Project.responseDto.StockResponse;
import com.example.Stock_Details_Subscription_Project.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    PolygonServiceImpl polygonService;
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;
    @Override
    public void sendSubscriptionEmail(Subscription subscription) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String currDate = date.format(formatter);
        System.out.println(currDate);


        LocalDate preDate = LocalDate.now();
        preDate = preDate.minusDays(subscription.getIntervalDays());
        String preDateInfo = preDate.format(formatter);
        System.out.println(preDateInfo);


        List<StockResponse>  responseList = polygonService.getStockDetails(subscription.getStockSymbol(),
                  preDateInfo , currDate);

        System.out.println(responseList);

        StringBuilder messageBody = new StringBuilder();
        for(StockResponse stockResponse: responseList){
            messageBody.append(stockResponse.toString()).append("\n");
        }

        try {
            mailMessage.setFrom(sender);
            mailMessage.setTo(subscription.getEmail());
            mailMessage.setSubject("Stock Update of ticker: "+ subscription.getStockSymbol() +
                    " from: " +preDateInfo+ " to: "+currDate);
            mailMessage.setText("Dear User, "+"\n"+"Please refer to the stock details for: "+subscription.getStockSymbol()
                    + " from "+preDateInfo+" to " +currDate+ " below: " +"\n"+messageBody.toString());
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return;

    }
}
