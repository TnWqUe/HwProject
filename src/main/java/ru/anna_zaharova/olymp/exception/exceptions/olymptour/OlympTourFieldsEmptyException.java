package ru.anna_zaharova.olymp.exception.exceptions.olymptour;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OlympTourFieldsEmptyException extends BaseException {
    public OlympTourFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
