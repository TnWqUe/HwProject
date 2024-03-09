package ru.anna_zaharova.olymp.exception.exceptions.discipline;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DisciplineNotFoundException extends BaseException {
    public DisciplineNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
