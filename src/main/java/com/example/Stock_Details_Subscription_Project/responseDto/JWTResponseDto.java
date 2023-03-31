package com.example.Stock_Details_Subscription_Project.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class JWTResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
}
