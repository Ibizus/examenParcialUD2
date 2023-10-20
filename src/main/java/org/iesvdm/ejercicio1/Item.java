package org.iesvdm.ejercicio1;

import java.math.BigDecimal;

public class Item {

    // ATTRIBUTES:
    public String description;
    private BigDecimal weight;
    private BigDecimal price;


    // CONSTRUCTOR:
    public Item(String description, BigDecimal weight, BigDecimal price) {
        this.description = description;
        this.weight = weight;
        this.price = price;
    }

    // GETTERS:
    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
