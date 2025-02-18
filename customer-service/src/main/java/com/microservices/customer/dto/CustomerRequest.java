package com.microservices.customer.dto;

import java.math.BigDecimal;

public record CustomerRequest(String id, String firstName, String lastName,String userName, String email, String description) {

}
