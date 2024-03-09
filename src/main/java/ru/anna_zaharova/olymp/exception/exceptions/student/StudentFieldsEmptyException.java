package ru.anna_zaharova.olymp.exception.exceptions.student;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class StudentFieldsEmptyException extends BaseException {
    public StudentFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
