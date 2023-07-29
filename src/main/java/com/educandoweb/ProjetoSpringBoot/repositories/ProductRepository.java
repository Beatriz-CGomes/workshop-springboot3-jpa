package com.educandoweb.ProjetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.ProjetoSpringBoot.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
