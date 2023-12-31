package com.educandoweb.ProjetoSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.ProjetoSpringBoot.entites.User;
import com.educandoweb.ProjetoSpringBoot.repositories.UserRepository;
import com.educandoweb.ProjetoSpringBoot.services.exceptions.DatabaseException;
import com.educandoweb.ProjetoSpringBoot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	// RETORNAR O USUARIO SALVO
	public User insert(User obj) {
		return repository.save(obj);
	}

	// DELETAR USUARIO
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	// ATUALIZAR USUARIO
	public User update(Long id, User obj) {
		try {
			User us = repository.getReferenceById(id);
			update(us, obj);
			return repository.save(us);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void update(User us, User obj) {
		us.setName(obj.getName());
		us.setEmail(obj.getEmail());
		us.setPhone(obj.getPhone());
	}
}
