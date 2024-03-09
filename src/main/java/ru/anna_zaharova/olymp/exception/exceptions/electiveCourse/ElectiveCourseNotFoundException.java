package ru.anna_zaharova.olymp.exception.exceptions.electiveCourse;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class ElectiveCourseNotFoundException extends BaseException {
    public ElectiveCourseNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
