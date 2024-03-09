package ru.anna_zaharova.olymp.exception.exceptions.discipline;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DisciplineFieldsEmptyException extends BaseException {
    public DisciplineFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
