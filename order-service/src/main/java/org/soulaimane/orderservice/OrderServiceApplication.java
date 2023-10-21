package org.soulaimane.orderservice;

import lombok.AllArgsConstructor;
import org.soulaimane.orderservice.entities.Order;
import org.soulaimane.orderservice.entities.ProductItem;
import org.soulaimane.orderservice.enums.OrderStatus;
import org.soulaimane.orderservice.model.Customer;
import org.soulaimane.orderservice.model.Product;
import org.soulaimane.orderservice.repo.OrderRepository;
import org.soulaimane.orderservice.repo.ProductItemRepository;
import org.soulaimane.orderservice.service.CustomerRestClientService;
import org.soulaimane.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService){
		return args -> {
			List<Customer> customers =customerRestClientService.allCustomer().getContent().stream().toList();
			List<Product> products =inventoryRestClientService.allProduct().getContent().stream().toList();
			Long customerId=1L;
			Customer customer=customerRestClientService.customerById(customerId);
			Random random=new Random();
			for (int i = 0; i <20 ; i++) {
				Order order= Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.orderStatus(Math.random()>0.5 ?OrderStatus.CANCELED:OrderStatus.DELIVERED)
						.CreatAt(new Date())
						.build();
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < products.size(); j++) {
					if (Math.random()>0.4){
						ProductItem productItem= ProductItem.builder()
								.order(savedOrder)
								.productId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(1+random.nextInt(20))
								.discount(0)
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}


				}

			}



		};
	}

}
