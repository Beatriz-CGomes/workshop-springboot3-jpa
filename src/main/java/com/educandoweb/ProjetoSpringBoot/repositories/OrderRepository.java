package com.educandoweb.ProjetoSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.ProjetoSpringBoot.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
