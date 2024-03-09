package ru.anna_zaharova.olymp.exception.exceptions.language;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class LanguageFieldsEmptyException  extends BaseException {
    public LanguageFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
