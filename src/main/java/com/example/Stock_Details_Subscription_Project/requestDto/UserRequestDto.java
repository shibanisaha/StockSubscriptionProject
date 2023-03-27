package com.example.Stock_Details_Subscription_Project.requestDto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;

@Data
public class UserRequestDto {

    @NotEmpty(message = "Id required")
    private String id;
    @NotEmpty(message = "first name required")
    private String first_name;

    @NotEmpty(message = "Last name required")
    private String last_name;

    @NotEmpty
    @Email(message = "Please enter valid email")
    private String email;

    @NotEmpty(message = "Phone number required")
    private String phone_number;

    @NotEmpty
    @Size(min=4, message = "Minimum four character required")
    private String password;
}
