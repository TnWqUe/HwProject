package ru.anna_zaharova.olymp.exception.exceptions.user;
import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;
/**
 * Пустые поля при работе с пользователем
 */
public class UserFieldsEmptyException extends BaseException {
    public UserFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
