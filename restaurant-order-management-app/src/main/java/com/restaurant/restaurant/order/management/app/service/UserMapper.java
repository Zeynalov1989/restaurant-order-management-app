package com.restaurant.restaurant.order.management.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.stereotype.Component;

import com.restaurant.restaurant.order.management.app.role.ERole;
import com.restaurant.restaurant.order.management.app.user.UserDTO;
import com.restaurant.restaurant.order.management.app.user.UserEntity;


@Component
public class UserMapper {

    public UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setRoles(userEntity.getRole().stream()
                .map(Role::getName)
                .collect(Collectors.toList()));
        return userDTO;
    }

    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setRoles(userDTO.getRoles().stream()
                .map(Role::new)
                .collect(Collectors.toList()));
        return userEntity;
    }

}
