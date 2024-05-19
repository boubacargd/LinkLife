package org.example.backend_app.authentication.service;

import org.example.backend_app.authentication.dto.UserDto;

public interface UserService {

    String addUser(UserDto userDto);
}
