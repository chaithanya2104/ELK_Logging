package com.example.Sales.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //list of item_names are got from the order()
    private String itemName;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //    @OneToOne
//    @JoinColumn
    private Long orderId;

    public OrderLineItem() {
    }

    public OrderLineItem(String itemName,Long orderId){
        this.itemName=itemName;
        this.orderId=orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getOrderId() {return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
