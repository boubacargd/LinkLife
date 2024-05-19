package org.example.backend_app.authentication.service.impl;

import org.example.backend_app.authentication.dto.UserDto;
import org.example.backend_app.authentication.entity.UserEntity;
import org.example.backend_app.authentication.repo.UserRepo;
import org.example.backend_app.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class userImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {

        UserEntity userEntity = new UserEntity (
            userDto.getUserId(),
            userDto.getFirstName(),
            userDto.getEmail(),
            this.passwordEncoder.encode(userDto.getPassword())
        );

        userRepo.save(userEntity);
        return userEntity.getFirstName();

    }
}
