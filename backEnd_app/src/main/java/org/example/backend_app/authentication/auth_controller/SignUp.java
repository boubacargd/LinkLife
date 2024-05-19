package org.example.backend_app.authentication.auth_controller;


import org.example.backend_app.authentication.dto.UserDto;
import org.example.backend_app.authentication.entity.UserEntity;
import org.example.backend_app.authentication.repo.UserRepo;
import org.example.backend_app.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/auth")
public class SignUp {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public UserEntity register(@RequestBody UserEntity userEntity ) {
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
        System.out.println("Registered!");
        return userRepo.save(userEntity);
    }
}
