package org.iesvdm.ejercicio1;


import java.awt.geom.GeneralPath;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class OrderDetail{

    public Order order;
    public Item item;
    public int quantity;
    public TaxType tax;


    // CONSTRUCTOR:
    public OrderDetail(Order order, Item item, int quantity, TaxType tax) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
        this.tax = tax;
    }

    // METHODS:
    public BigDecimal calcSubTotal(){

        BigDecimal priceWithOutTaxes = this.item.getPrice().multiply(BigDecimal.valueOf(quantity));
        return priceWithOutTaxes.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcWeight(){

        BigDecimal totalWeight = this.item.getWeight().multiply(BigDecimal.valueOf(quantity));
        return totalWeight.setScale(3, RoundingMode.HALF_UP);
    }

}
