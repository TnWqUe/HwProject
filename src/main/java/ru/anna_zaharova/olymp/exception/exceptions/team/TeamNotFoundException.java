package ru.anna_zaharova.olymp.exception.exceptions.team;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class TeamNotFoundException  extends BaseException {
    public TeamNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}