package org.example.backend_app.authentication.auth_controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.backend_app.authentication.entity.UserEntity;
import org.example.backend_app.authentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class SignIn {

    private final UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    public SignIn(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/signin")
    public Optional<UserEntity> login(@RequestBody UserCredential userCredential) {
        System.out.println("Logged!");
        return userRepo.findOneByEmailAndPassword(userCredential.email, userCredential.password);
    }


    public record UserCredential(String email, String password) {
    }

}
