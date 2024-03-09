package ru.anna_zaharova.olymp.exception.exceptions.olympformat;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OlympFormatFieldsEmptyException extends BaseException {
    public OlympFormatFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
