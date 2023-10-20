package org.iesvdm;

import org.iesvdm.ejercicio1.Item;
import org.iesvdm.ejercicio1.Order;
import org.iesvdm.ejercicio1.OrderDetail;
import org.iesvdm.ejercicio1.TaxType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderTest {

    Order tested = new Order();
    Item item1;
    Item item2;

    @Test
    @BeforeEach
    public void createItems(){

        item1 = new Item("Western Digital Unidad interna de estado sólido SSD WD SN580 NVMe azul de 1 TB",
                BigDecimal.valueOf(0.395), BigDecimal.valueOf(52.99));
        item2 = new Item("Apple MacBook Pro M1 Pro",
                BigDecimal.valueOf(1.3), BigDecimal.valueOf(1758.95));

        Assertions.assertEquals(BigDecimal.valueOf(52.99) ,item1.getPrice());
        Assertions.assertEquals(BigDecimal.valueOf(1.3) ,item2.getWeight());
    }

    @Test
    public void createOrderWorks(){

        Assertions.assertEquals(LocalDate.now(), tested.date);
    }

    @Test
    public void introduceDetailsintoOrder(){

        tested.setDetail(new OrderDetail(tested, item1, 3, TaxType.General));
        tested.setDetail(new OrderDetail(tested, item2, 2, TaxType.Reduced));

        Assertions.assertEquals(2, tested.details.size());
    }

    @Test
    public void methodsInOrderClassWorks(){
        tested.setDetail(new OrderDetail(tested, item1, 3, TaxType.General));
        tested.setDetail(new OrderDetail(tested, item2, 2, TaxType.Reduced));

        Assertions.assertEquals(BigDecimal.valueOf(3676.87), tested.calcNetTotal());
        //Assertions.assertEquals(BigDecimal.valueOf(5), tested.calcVAT());
        //Assertions.assertEquals(BigDecimal.valueOf(5), tested.calcGrossTotal());
    }

}
