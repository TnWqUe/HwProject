package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.user.EditPasswordRequest;
import ru.anna_zaharova.olymp.rest.dto.response.user.UserDto;
import ru.anna_zaharova.olymp.rest.dto.request.user.EditUserRequest;
import ru.anna_zaharova.olymp.rest.dto.request.user.NewUserRequest;

import java.util.List;

public interface UserService {
    Long addNewUser(NewUserRequest request);

    List<UserDto> findAllUsers();

    UserDto findById(Long id);

    void deleteById(Long id);

    UserDto edit(Long id, EditUserRequest request);

    UserDto editPassword(Long id, EditPasswordRequest request);
}
