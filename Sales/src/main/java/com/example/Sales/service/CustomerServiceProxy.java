package com.example.Sales.service;

import com.example.Sales.model.Customers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name="customer-service", url="localhost:8080")
//@FeignClient(name="customer-service")
@FeignClient(name="zuul-gateway", fallback = HystrixProxyFallBack.class)
//@RibbonClient(name="customer-service")
public interface CustomerServiceProxy {

//    @GetMapping("/customers/{email}")
@GetMapping("customer-service/customer-api2/customers/{email}")
    Customers getCustomerByEmail(@PathVariable("email") String email);

//    @GetMapping("/customers")
    @GetMapping("customer-service/customer-api2/customers")
    List<Customers> getAllCustomers();
}
