package org.soulaimane.orderservice.web;

import lombok.AllArgsConstructor;
import org.soulaimane.orderservice.entities.Order;
import org.soulaimane.orderservice.entities.ProductItem;
import org.soulaimane.orderservice.exceptions.OrderNotFoundException;
import org.soulaimane.orderservice.model.Customer;
import org.soulaimane.orderservice.model.Product;
import org.soulaimane.orderservice.repo.OrderRepository;
import org.soulaimane.orderservice.repo.ProductItemRepository;
import org.soulaimane.orderservice.service.CustomerRestClientService;
import org.soulaimane.orderservice.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;
    @GetMapping("/orderDetails/{orderId}")
    public Order getOrder(@PathVariable Long orderId) throws OrderNotFoundException {
        Order order=orderRepository.findById(orderId).orElse(null);
        if (order==null){
            throw new OrderNotFoundException("Order Not Found");
        }
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(productItem ->{
            Product product=inventoryRestClientService.productById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return order;


    }
}
