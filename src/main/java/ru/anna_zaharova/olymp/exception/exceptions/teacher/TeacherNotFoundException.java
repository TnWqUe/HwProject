package ru.anna_zaharova.olymp.exception.exceptions.teacher;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class TeacherNotFoundException extends BaseException {
    public TeacherNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
