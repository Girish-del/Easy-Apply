package com.microservices.job.dto;

public record JobRequest(Long id, String orderNumber,
                         String skuCode, String price,
                         Integer quantity, String description) {

}
