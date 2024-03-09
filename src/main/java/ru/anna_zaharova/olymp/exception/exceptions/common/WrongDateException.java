package ru.anna_zaharova.olymp.exception.exceptions.common;

import org.springframework.http.HttpStatus;
/**
 * Неверная дата
 */
public class WrongDateException extends BaseException {
    public WrongDateException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
