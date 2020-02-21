package com.example.Sales.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CreateOrder {

    private String description;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date date;


    @Email
    private String email;

    private List<String> items;

    public CreateOrder() {
        this.date= new Date();
        System.out.println("default no-arg constructor called");
    }

    public CreateOrder(String description, Date date, @Email String email, List<String> items) {
        this.description = description;
        this.date = date;
        this.email = email;
        this.items = items;
        System.out.println("create order args constructor called");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
