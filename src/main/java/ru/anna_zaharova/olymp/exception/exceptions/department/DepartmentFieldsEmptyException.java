package ru.anna_zaharova.olymp.exception.exceptions.department;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DepartmentFieldsEmptyException  extends BaseException {
    public DepartmentFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}