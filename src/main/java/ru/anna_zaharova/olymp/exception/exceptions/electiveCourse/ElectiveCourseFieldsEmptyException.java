package ru.anna_zaharova.olymp.exception.exceptions.electiveCourse;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class ElectiveCourseFieldsEmptyException extends BaseException {
    public ElectiveCourseFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
