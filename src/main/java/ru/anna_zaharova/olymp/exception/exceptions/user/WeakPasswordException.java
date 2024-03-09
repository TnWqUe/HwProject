package ru.anna_zaharova.olymp.exception.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;
/**
 * Слабый пароль
 */
public class WeakPasswordException extends BaseException {
    public WeakPasswordException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
