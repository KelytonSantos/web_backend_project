package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
