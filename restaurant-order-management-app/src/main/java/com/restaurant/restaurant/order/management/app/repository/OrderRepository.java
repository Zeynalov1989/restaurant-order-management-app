package com.restaurant.restaurant.order.management.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restaurant.order.management.app.order.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
 
