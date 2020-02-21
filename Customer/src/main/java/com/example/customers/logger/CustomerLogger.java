package com.example.customers.logger;


import com.example.customers.controller.CustomerController;
import com.example.customers.service.CustomerService;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
public class CustomerLogger {

    private CustomerController customerController;
    private CustomerService customerService;
    private Timestamp timestamp;
    private String method;
    private List Response;
    private String message;



    public CustomerLogger(CustomerController customerController,CustomerService customerService){
        this.customerController=customerController;
        this.customerService=customerService;
    }

//    getAllCustomersLogger-method: GetALLCustomers,TimeStamp:/,returnedCustomersArray:[]
    public void getAllCustomersLogger(List Customers){

        //sends all parameters to toJSON method

         String  stringValue= "Log [Method= GetAllCustomers" + ", Timestamp=" + getTimeStamp()  + ", return=" + Customers + "]";


    }

//    getCustomerByEmailLogger- method:GetCustomerByEmail,TimeStamp,Email,returnedValue

//    addNewCustomerLogger-method:addCustomer,TimeStamp,CustomerDetails JSON obj,result

//TimeStamp
    public Timestamp getTimeStamp(){
        Date date=new Date();
        Timestamp ts = new Timestamp(date.getTime());
        return ts;
    }





}
