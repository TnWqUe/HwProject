package ru.anna_zaharova.olymp.exception.exceptions.language;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class LanguageNotFoundException  extends BaseException {
    public LanguageNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
