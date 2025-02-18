package com.microservices.customer.dto;

import java.math.BigDecimal;

public record CustomerResponse(String id, String firstName, String lastName,String userName, String email, String description) {
}
