package com.educandoweb.ProjetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.ProjetoSpringBoot.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
