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

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currDate = date.format(formatter);


        LocalDate preDate = subscription.getLastSentDay();
        if(subscription.getIntervalDays()==1){
            preDate = preDate.minus(Duration.ofDays(1));
        }
        String preDateInfo = preDate.format(formatter);


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
                    + " from: "+preDateInfo+" to: " +currDate+ " below: " +"\n"+messageBody.toString());
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return;

    }
}
