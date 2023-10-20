package org.iesvdm.ejercicio1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

enum Status {Pending, Payment_Complete};
public class Order {

    public LocalDate date;
    public Status status;
    public List<OrderDetail> details = new ArrayList<>();



    // CONSTRUCTOR:

    public Order() {
        this.date = LocalDate.now();
        this.status = Status.Pending;
    }


    // METHODS:
    public BigDecimal calcNetTotal(){

        BigDecimal netAmount = new BigDecimal("0");

        for (OrderDetail line: this.details){
            netAmount = netAmount.add(line.calcSubTotal());
        }
        return netAmount.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcVAT(){

        BigDecimal vat = BigDecimal.valueOf(0);

        for (OrderDetail line: this.details){

            BigDecimal taxAmount;
            switch (line.tax){
                case Reduced -> taxAmount = BigDecimal.valueOf(10);
                case Superreduced -> taxAmount = BigDecimal.valueOf(4);
                default -> taxAmount = BigDecimal.valueOf(21);
            }

            BigDecimal taxApplied = taxAmount.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
            BigDecimal lineVat = line.calcSubTotal().multiply(taxApplied);

            vat = vat.add(lineVat);
        }
        return vat.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calcGrossTotal(){

        return this.calcNetTotal().add(this.calcVAT()).setScale(2, RoundingMode.HALF_UP);
    }

    // GETTERS & SETTERS:

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDetail(OrderDetail detail) {
        this.details.add(detail);
    }
}
