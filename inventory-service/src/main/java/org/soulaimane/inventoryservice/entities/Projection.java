package org.soulaimane.inventoryservice.entities;
@org.springframework.data.rest.core.config.Projection(name = "fullProduct",types = Product.class)
public interface Projection {
      Long getId() ;
     String getName();
     double getPrice();
     int getQuantity();
}
