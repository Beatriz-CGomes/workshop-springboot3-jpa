package com.educandoweb.ProjetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.ProjetoSpringBoot.entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
