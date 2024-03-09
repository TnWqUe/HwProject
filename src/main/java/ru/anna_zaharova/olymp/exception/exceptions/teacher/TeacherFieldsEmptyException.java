package ru.anna_zaharova.olymp.exception.exceptions.teacher;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class TeacherFieldsEmptyException extends BaseException {
    public TeacherFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
