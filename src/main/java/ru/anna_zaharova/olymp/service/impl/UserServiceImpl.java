package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.User;
import ru.anna_zaharova.olymp.exception.exceptions.EmptyFieldsException;
import ru.anna_zaharova.olymp.exception.exceptions.NotFoundException;
import ru.anna_zaharova.olymp.exception.exceptions.WeakPasswordException;
import ru.anna_zaharova.olymp.repo.UserRepo;
import ru.anna_zaharova.olymp.rest.dto.UserDto;
import ru.anna_zaharova.olymp.rest.dto.user.EditUserRequest;
import ru.anna_zaharova.olymp.rest.dto.user.NewUserRequest;
import ru.anna_zaharova.olymp.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public List<UserDto> findAllUsers() {
        List<User> all = userRepo.findAll();

        return all.stream()
                .map(user -> UserDto.builder()
                        .email(user.getEmail())
                        .surname(user.getSurname())
        .usrname(user.getUsrname())
        .patronymic(user.getPatronymic())
                         .build())
                .toList();
    }

    @Override
    public Long addNewUser(NewUserRequest request) {

        if (!StringUtils.hasText(request.getEmail()) ||
                !StringUtils.hasText(request.getSurname()) ||
                !StringUtils.hasText(request.getUsrname()) ||
                !StringUtils.hasText(request.getPatronymic()) ||
                !StringUtils.hasText(request.getPassword())) {
            throw new EmptyFieldsException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }


        if (request.getPassword().length() < 8) {
            throw new WeakPasswordException("Пароль слишком слабый - необходимо как минимум 8 знаков");
        }

        User user = new User();
        user.setSurname(request.getSurname());
        user.setUsrname(request.getUsrname());
        user.setPatronymic(request.getPatronymic());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setCreatedAt(LocalDate.now());

        userRepo.saveAndFlush(user);

        return user.getId();
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> userFromDb = userRepo.findById(id);

        if (userFromDb.isEmpty()) {
            throw new NotFoundException("Не найден пользователь с id = " + id);
        }

        User user = userFromDb.get();
        return buildDto(user);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepo.existsById(id)) {
            throw new NotFoundException("Не найден пользователь с id = " + id);
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDto edit(Long id, EditUserRequest request) {
        Optional<User> userFromDb = userRepo.findById(id);

        if (userFromDb.isEmpty()) {
            throw new NotFoundException("Не найден пользователь с id = " + id);
        }

        if (!StringUtils.hasText(request.getEmail()) ||
                !StringUtils.hasText(request.getSurname()) ||
                !StringUtils.hasText(request.getUsrname()) ||
                !StringUtils.hasText(request.getPatronymic())) {
            throw new EmptyFieldsException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        User user = userFromDb.get();

        user.setSurname(request.getSurname());
        user.setUsrname(request.getUsrname());
        user.setPatronymic(request.getPatronymic());
        user.setEmail(request.getEmail());

        userRepo.save(user);

        return buildDto(user);
    }

    private UserDto buildDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .surname(user.getSurname())
                .usrname(user.getUsrname())
                .patronymic(user.getPatronymic())
                .build();
    }
}
