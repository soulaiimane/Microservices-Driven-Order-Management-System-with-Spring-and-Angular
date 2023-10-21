package org.soulaimane.inventoryservice;

import org.soulaimane.inventoryservice.entities.Product;
import org.soulaimane.inventoryservice.rapo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder().name("iphone-8").price(3545.0).quantity(20).build(),
					Product.builder().name("iphone-x").price(5545.0).quantity(13).build(),
					Product.builder().name("iphone-11").price(7545.0).quantity(19).build(),
					Product.builder().name("iphone-11-pro").price(8545.0).quantity(18).build(),
					Product.builder().name("iphone-12").price(9545.0).quantity(10).build(),
					Product.builder().name("iphone-12-pro").price(10545.0).quantity(16).build(),
					Product.builder().name("iphone-13").price(11545.0).quantity(20).build(),
					Product.builder().name("iphone-13-pro").price(12545.0).quantity(5).build(),
					Product.builder().name("iphone-14").price(13545.0).quantity(19).build(),
					Product.builder().name("iphone-14-pro").price(15545.0).quantity(4).build(),
					Product.builder().name("iphone-15").price(20545.0).quantity(9).build(),
					Product.builder().name("iphone-15-pro").price(22545.0).quantity(7).build()

			));
		};

	}

}
