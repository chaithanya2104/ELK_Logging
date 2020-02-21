package com.example.Sales.service;

import com.example.Sales.model.Customers;
import com.example.Sales.model.Items;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HystrixProxyFallBack implements ItemServiceProxy,CustomerServiceProxy {

    @Override
    public Customers getCustomerByEmail(String email) {
        System.out.println("Customer Service not reachable");
        return null;
    }

    @Override
    public List<Customers> getAllCustomers() {
        System.out.println("Customer Service not reachable");
        return null;
    }

    @Override
    public Items getItemByName(String name) {
        System.out.println("Item Service not reachable");
        return null;
    }

    @Override
    public List<Items> getAllItems() {
        System.out.println("Item Service not reachable");
        return null;
    }
}
