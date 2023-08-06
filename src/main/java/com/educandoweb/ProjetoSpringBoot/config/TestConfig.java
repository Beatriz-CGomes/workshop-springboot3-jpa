package com.educandoweb.ProjetoSpringBoot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.ProjetoSpringBoot.entites.Category;
import com.educandoweb.ProjetoSpringBoot.entites.Order;
import com.educandoweb.ProjetoSpringBoot.entites.OrderItem;
import com.educandoweb.ProjetoSpringBoot.entites.Payment;
import com.educandoweb.ProjetoSpringBoot.entites.Product;
import com.educandoweb.ProjetoSpringBoot.entites.User;
import com.educandoweb.ProjetoSpringBoot.entites.enums.OrderStatus;
import com.educandoweb.ProjetoSpringBoot.repositories.CategoryRepository;
import com.educandoweb.ProjetoSpringBoot.repositories.OrderItemRepository;
import com.educandoweb.ProjetoSpringBoot.repositories.OrderRepository;
import com.educandoweb.ProjetoSpringBoot.repositories.ProductRepository;
import com.educandoweb.ProjetoSpringBoot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	// TUDO O QUE FOR COLOCADO DENTRO DESSE METADO SERÁ EXECUTADO QUANDO A APLICAÇÃO
	// FOR INICIADA

	@Override
	public void run(String... args) throws Exception {

		// CATEGORY - que não tem relação com as outras tabelas somente com product
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		// PRODUCT
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		// SALVANDO CATEGORIA E PRODUTO
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// ADICIONADO A CATEGORIA AO PRODUTO
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		// SALVANDO PRODUTOS COM AS SUAS CATEGOTEGORIAS
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// USER
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// ORDER
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		// ORDEMITEM TEM UMA ASSOCIAÇÃO COM ORDER E PRODUCT
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		// SALVANDO ORDERITEM
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2019-07-21T21:42:10Z"), o2);
		
		//PARA SALVAR O OBJETO DE UM OBJETO DEPENDETE 
		o2.setPayment(pay1);
		
		orderRepository.save(o2);
	}

}
