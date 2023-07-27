package com.educandoweb.ProjetoSpringBoot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.ProjetoSpringBoot.entites.User;

@RestController //informando que é uma controller
@RequestMapping("/users") //passando o caminho na url
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Maria", "mara@email.com", "9999999", "123456");
		return ResponseEntity.ok().body(user);
	}
	
}
