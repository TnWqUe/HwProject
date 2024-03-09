package ru.anna_zaharova.olymp.exception.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;
/**
 * Пользователь не найден
 */
public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
