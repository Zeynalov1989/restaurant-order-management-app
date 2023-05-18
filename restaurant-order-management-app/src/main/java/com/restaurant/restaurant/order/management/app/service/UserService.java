package com.restaurant.restaurant.order.management.app.service;

import org.springframework.stereotype.Service;


import com.restaurant.restaurant.order.management.app.repository.UserRepository;
import com.restaurant.restaurant.order.management.app.role.Role;
import com.restaurant.restaurant.order.management.app.user.UserDTO;
import com.restaurant.restaurant.order.management.app.user.UserEntity;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO registerUser(UserDTO userDTO) {
        // UserDTO'dan UserEntity'ye dönüştürme işlemi
        UserEntity userEntity = UserMapper.toEntity(userDTO);

        // Şifreyi hashleme ve kullanıcının rolünü belirleme işlemleri
        userEntity.setPassword(Hashing.sha256().hashString(userEntity.getPassword(), StandardCharsets.UTF_8).toString());
        userEntity.setRole(Role.USER);

        // Veritabanına kaydetme işlemi
        UserEntity savedUser = userRepository.save(userEntity);

        // UserEntity'den UserDTO'ya dönüştürme işlemi
        return UserMapper.toDTO(savedUser);
    }

    // Diğer iş mantığı metotları buraya eklenebilir
}

