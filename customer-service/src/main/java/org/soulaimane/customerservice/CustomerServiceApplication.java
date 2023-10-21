package org.soulaimane.customerservice;

import org.soulaimane.customerservice.entities.Customer;
import org.soulaimane.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);

	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
		customerRepository.saveAll(List.of(
				Customer.builder() .name("soulaimane").email("soulaimane@gmail.com").build(),
				Customer.builder() .name("said").email("said@gmail.com").build(),
				Customer.builder() .name("saad").email("saad@gmail.com").build(),
				Customer.builder() .name("soad").email("soad@gmail.com").build(),
				Customer.builder() .name("samir").email("samir@gmail.com").build()
		));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
