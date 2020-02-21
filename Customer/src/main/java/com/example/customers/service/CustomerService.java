package com.example.customers.service;

import com.example.customers.exception.*;
import com.example.customers.model.Customers;
import org.springframework.stereotype.Service;
import com.example.customers.repository.CustomerRepository;



import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    //    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    //create new Customer
    public Customers add(Customers customers){
        System.out.println("Added the customer");
        return customerRepository.save(customers);
    }

    //getAll
    public List<Customers> getAll(){
        System.out.println("Got all the Customers");
        return customerRepository.findAll();
    }

    //getCustomerByEmail
    public Customers getCustomerByEmail(String email){
        Optional <Customers> customerWithEmail = customerRepository.findByEmail(email);
        if(customerWithEmail.isPresent()){
            System.out.println("got the customer from email");
            return customerWithEmail.get();
        }
        else{
            throw new CustomerNotFoundException("Customer not found for email: "+ email);
        }

    }

}