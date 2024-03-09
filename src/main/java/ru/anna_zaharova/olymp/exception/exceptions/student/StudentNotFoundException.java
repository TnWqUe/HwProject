package ru.anna_zaharova.olymp.exception.exceptions.student;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class StudentNotFoundException extends BaseException {
    public StudentNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
