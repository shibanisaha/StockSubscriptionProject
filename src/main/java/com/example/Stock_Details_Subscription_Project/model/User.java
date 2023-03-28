package com.example.Stock_Details_Subscription_Project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "Users")
public class User {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    @UniqueElements
    private String email;
    private String phone_number;
    private String password;

}
