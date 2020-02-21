package com.example.Sales.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @OneToOne(mappedBy = "order_id")
    private Long id;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
   @CreatedDate
   @Column(nullable = false, updatable = false)
    private Date date;
//    @Email
    private String email;

    private String description;
    private double price;

//    public List<String> getItems() {
//        return items;
//    }

//    public void setItems(List<String> items) {
//        this.items = items;
//    }
//
//    @ElementCollection
//    private List<String> items;

    public SalesOrder() {
    }

    public SalesOrder(Date date, String email, String description, double price){
        this.date=date;
        this.email=email;
        this.description=description;
        this.price=price;
//        this.items=items;
    }

    @Override
    public String toString() {
        return "sales_order{" +
                "id=" + id +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
