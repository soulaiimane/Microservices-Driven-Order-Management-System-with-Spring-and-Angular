package org.soulaimane.orderservice.entities;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import org.soulaimane.orderservice.enums.OrderStatus;
import org.soulaimane.orderservice.model.Customer;

import java.util.Date;
import java.util.List;

@org.springframework.data.rest.core.config.Projection(name = "fullOrder",types = Order.class)
public interface Projection {
      Long getId();
      Date getCreatAt();
      OrderStatus getOrderStatus();
      Long getCustomerId();

}
