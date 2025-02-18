package com.microservices.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {

    //Id must be not null
    private String id;
    private String firstName;
    private String lastName;
    //UserName must be unique
    private String userName;
    private String email;
    private String description;
}
