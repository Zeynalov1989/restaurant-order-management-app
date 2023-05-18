package com.restaurant.restaurant.order.management.app.order;

import java.util.List;

import com.restaurant.restaurant.order.management.app.menu.item.MenuItemDTO;
import com.restaurant.restaurant.order.management.app.user.UserDTO;

public class OrderDTO {
    private Long id;
    private List<MenuItemDTO> items;
    private Double totalCost;
    private UserDTO user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<MenuItemDTO> getItems() {
		return items;
	}
	public void setItems(List<MenuItemDTO> items) {
		this.items = items;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public OrderDTO(Long id, List<MenuItemDTO> items, Double totalCost, UserDTO user) {
		super();
		this.id = id;
		this.items = items;
		this.totalCost = totalCost;
		this.user = user;
	}

    
}
