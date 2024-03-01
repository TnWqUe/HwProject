package ru.anna_zaharova.olymp.exception.exceptions;

import org.springframework.http.HttpStatus;

public class EmptyFieldsException extends BaseException {
    public EmptyFieldsException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
