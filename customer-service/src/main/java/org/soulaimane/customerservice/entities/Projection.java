package org.soulaimane.customerservice.entities;
@org.springframework.data.rest.core.config.Projection(name = "fullCustomer",types = Customer.class)
public interface Projection {
     Long getId();
     String getName();
     String getEmail();
}
