package com.cjafet.datajpa.data;

import javax.persistence.*;

@Entity
// will give a Failed to initialize JPA EntityManagerFactory: Foreign key circularity dependency involving the following tables: plant, plant
//@Table(name = "plant")
public class Flower extends Plant {

    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
