package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.UserDto;
import ru.anna_zaharova.olymp.rest.dto.user.EditUserRequest;
import ru.anna_zaharova.olymp.rest.dto.user.NewUserRequest;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers();
    Long addNewUser(NewUserRequest request);

    UserDto findById(Long id);

    void deleteById(Long id);

    UserDto edit(Long id, EditUserRequest request);
}
