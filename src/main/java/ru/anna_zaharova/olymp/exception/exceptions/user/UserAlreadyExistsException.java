package ru.anna_zaharova.olymp.exception.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;
/**
 * Пользователь уже существует
 */
public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(String message) {super(HttpStatus.BAD_REQUEST,message);}
}
