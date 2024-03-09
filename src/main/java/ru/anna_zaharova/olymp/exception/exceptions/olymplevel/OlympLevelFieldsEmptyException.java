package ru.anna_zaharova.olymp.exception.exceptions.olymplevel;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OlympLevelFieldsEmptyException  extends BaseException {
    public OlympLevelFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
