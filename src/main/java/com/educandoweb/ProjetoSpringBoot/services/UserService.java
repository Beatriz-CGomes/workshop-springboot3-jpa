package com.educandoweb.ProjetoSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.ProjetoSpringBoot.entites.User;
import com.educandoweb.ProjetoSpringBoot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	// RETORNAR O USUARIO SALVO
	public User insert(User obj) {
		return repository.save(obj);
	}

}
