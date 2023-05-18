package com.restaurant.restaurant.order.management.app.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant.order.management.app.menu.item.MenuItemDTO;
import com.restaurant.restaurant.order.management.app.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/items")
    public ResponseEntity<MenuItemDTO> createMenuItem(@RequestBody MenuItemDTO menuItemDTO) {
        MenuItemDTO createdMenuItemDTO = menuService.createMenuItem(menuItemDTO);
        return new ResponseEntity<>(createdMenuItemDTO, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<MenuItemDTO>> getMenuItems() {
        List<MenuItemDTO> menuItems = menuService.getAllMenuItems();
        return new ResponseEntity<>(menuItems, HttpStatus.OK);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<MenuItemDTO> getMenuItemById(@PathVariable Long id) {
        MenuItemDTO menuItem = menuService.getMenuItemById(id);
        return new ResponseEntity<>(menuItem, HttpStatus.OK);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<MenuItemDTO> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemDTO menuItemDTO) {
        MenuItemDTO updatedMenuItemDTO = menuService.updateMenuItem(id, menuItemDTO);
        return new ResponseEntity<>(updatedMenuItemDTO, HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

