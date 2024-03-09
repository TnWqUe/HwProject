package ru.anna_zaharova.olymp.exception.exceptions.olympformat;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OlympFormatNotFoundException extends BaseException {
    public OlympFormatNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
