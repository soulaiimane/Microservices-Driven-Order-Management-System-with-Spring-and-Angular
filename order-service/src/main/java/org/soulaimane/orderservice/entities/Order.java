package org.soulaimane.orderservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.soulaimane.orderservice.enums.OrderStatus;
import org.soulaimane.orderservice.model.Customer;

import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date CreatAt;
    private OrderStatus orderStatus;
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy ="order")
    private List<ProductItem> productItems;
    public double getTotal(){
        double totalPrice=0;
        for (ProductItem pi:productItems) {
            totalPrice+=pi.getPrice();
        }
        return totalPrice;
    }
}
