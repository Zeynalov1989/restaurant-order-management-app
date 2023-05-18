package com.restaurant.restaurant.order.management.app.order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restaurant.restaurant.order.management.app.repository.OrderRepository;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }
    
    public Order createOrder(Order order) {
    	return orderRepository.save(order);    }
    
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
    
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

	public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
