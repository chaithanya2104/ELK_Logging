package com.example.customers.controller;

import com.example.customers.model.Customers;
import com.example.customers.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController

public class CustomerController {
    @Value("${spring.application.name}")
    private String appName;

   private static final Logger logger = LoggerFactory.getLogger("com.example.customers.controller.CustomerController");
   private CustomerService service;
   ObjectMapper objectMapper = new ObjectMapper();

    private CustomerController (CustomerService service){
        this.service= service;
    }
    List<Customers>  customersList = new ArrayList<>();
    Optional <Customers> customerWithEmail;
    Customers customer;
    @GetMapping("/customers")
    public List<Customers> getAllCustomers() throws JsonProcessingException {
        customersList=service.getAll();
        MDC.put("returnAllCustomers",objectMapper.writeValueAsString(customersList));
        MDC.put("method","Get All Customers");
        logger.info(String.format(" getAllCustomers() method in %s invoked",appName));
        return customersList;
    }

    @GetMapping("/customers/{email}")
    public Optional<Customers> getCustomerByEmail(@PathVariable String email) throws JsonProcessingException {
        customerWithEmail = Optional.ofNullable(service.getCustomerByEmail(email));
        MDC.put("returnCustomersForEmail",objectMapper.writeValueAsString(customerWithEmail));
        MDC.put("inputEmail",email);
        MDC.put("method","Search Customer by email");
        logger.info(String.format(" getCustomerByEmail() method in %s invoked",appName));
        return customerWithEmail;
    }

    @PostMapping(value="customers/add", produces = "application/json")
    public Customers add(@RequestBody Customers customers) throws JsonProcessingException {
        customer = service.add(customers);
        MDC.put("addCustomer", objectMapper.writeValueAsString(customers));
        MDC.put("returnAddedCustomer",objectMapper.writeValueAsString(customer));
        MDC.put("method","Add Customer");
        logger.info(String.format(" add() method in %s invoked",appName));
        return customer;
    }
}
