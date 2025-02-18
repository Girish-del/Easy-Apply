package com.microservices.customer.service;

import com.microservices.customer.dto.CustomerRequest;
import com.microservices.customer.dto.CustomerResponse;
import com.microservices.customer.model.Customer;
import com.microservices.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .userName(customerRequest.userName())
                .email(customerRequest.email())
                .description(customerRequest.description())
                .build();
        customerRepository.save(customer);
        log.info("Customer Created Successfully");
        return new CustomerResponse(customer.getId(),customer.getFirstName(), customer.getLastName(),customer.getUserName(), customer.getEmail(),
                customer.getDescription());
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerResponse(customer.getId(),customer
                        .getFirstName(), customer.getLastName(),customer.getUserName(), customer.getEmail(),
                        customer.getDescription()))
                .toList();
    }
}
