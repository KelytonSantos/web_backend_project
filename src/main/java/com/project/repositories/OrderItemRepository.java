package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
