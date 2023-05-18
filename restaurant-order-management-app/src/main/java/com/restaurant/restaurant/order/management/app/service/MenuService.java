package com.restaurant.restaurant.order.management.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restaurant.restaurant.order.management.app.menu.MenuItemEntity;
import com.restaurant.restaurant.order.management.app.menu.item.MenuItemDTO;
import com.restaurant.restaurant.order.management.app.repository.MenuItemRepository;

@Service
public class MenuService {

    private final MenuItemRepository menuItemRepository;
    private final ModelMapper modelMapper;

    public MenuService(MenuItemRepository menuItemRepository, ModelMapper modelMapper) {
        this.menuItemRepository = menuItemRepository;
        this.modelMapper = modelMapper;
    }

    public MenuItemDTO createMenuItem(MenuItemDTO menuItemDTO) {
        MenuItemEntity menuItemEntity = modelMapper.map(menuItemDTO, MenuItemEntity.class);
        MenuItemEntity savedMenuItemEntity = menuItemRepository.save(menuItemEntity);
        return modelMapper.map(savedMenuItemEntity, MenuItemDTO.class);
    }

    public List<MenuItemDTO> getAllMenuItems() {
        List<MenuItemEntity> menuItemEntities = menuItemRepository.findAll();
        return menuItemEntities.stream()
                .map(menuItemEntity -> modelMapper.map(menuItemEntity, MenuItemDTO.class))
                .collect(Collectors.toList());
    }

    public MenuItemDTO getMenuItemById(Long id) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(id)
                .orElseThrow();
        return modelMapper.map(menuItemEntity, MenuItemDTO.class);
    }

    public MenuItemDTO updateMenuItem(Long id, MenuItemDTO menuItemDTO) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(id)
                .orElseThrow();
        menuItemEntity.setName(menuItemDTO.getName());
        menuItemEntity.setDescription(menuItemDTO.getDescription());
        menuItemEntity.setPrice(menuItemDTO.getPrice());
        MenuItemEntity savedMenuItemEntity = menuItemRepository.save(menuItemEntity);
        return modelMapper.map(savedMenuItemEntity, MenuItemDTO.class);
    }

    public void deleteMenuItem(Long id) {
        MenuItemEntity menuItemEntity = menuItemRepository.findById(id)
                .orElseThrow();
        menuItemRepository.delete(menuItemEntity);
    }
}

