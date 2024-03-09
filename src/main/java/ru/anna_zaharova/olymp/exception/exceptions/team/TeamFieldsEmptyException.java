package ru.anna_zaharova.olymp.exception.exceptions.team;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class TeamFieldsEmptyException extends BaseException {
    public TeamFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
