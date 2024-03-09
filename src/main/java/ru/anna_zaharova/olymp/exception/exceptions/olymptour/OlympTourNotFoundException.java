package ru.anna_zaharova.olymp.exception.exceptions.olymptour;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OlympTourNotFoundException extends BaseException {
    public OlympTourNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
