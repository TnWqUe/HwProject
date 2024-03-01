package ru.anna_zaharova.olymp.exception.exceptions;

import org.springframework.http.HttpStatus;

public class NullIdException extends BaseException {

    public NullIdException(String message)  {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
