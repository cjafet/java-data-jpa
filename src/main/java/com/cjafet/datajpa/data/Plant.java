package com.cjafet.datajpa.data;

import com.cjafet.datajpa.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

// Uses InheritanceType.JOINED to store shared fields in 'plant' and unique fields
// in subclass tables

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {

    @Id
    @GeneratedValue
    private Long id;

    @JsonView(Views.Public.class)
    @Nationalized
    private String name;

    @JsonView(Views.Public.class)
    @Column(precision=12, scale=4)
    private BigDecimal price;

    //many plants can belong to one delivery
    //don't retrieve delivery if we don't need it
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")  //map the join column in the plant table
    private Delivery delivery;

    // Convenience Constructor
    public Plant(String name, double price){
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public Plant() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
