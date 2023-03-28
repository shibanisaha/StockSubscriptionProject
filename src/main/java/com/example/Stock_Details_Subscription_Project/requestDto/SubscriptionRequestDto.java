package com.example.Stock_Details_Subscription_Project.requestDto;

import com.example.Stock_Details_Subscription_Project.Enum.NotificationFrequency;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class SubscriptionRequestDto {
    private  String stockSymbol;

    @Field("status")
    private NotificationFrequency notificationFrequency;
    private String notifyTime;
}

