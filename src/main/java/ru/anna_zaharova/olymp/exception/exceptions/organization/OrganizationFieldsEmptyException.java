package ru.anna_zaharova.olymp.exception.exceptions.organization;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OrganizationFieldsEmptyException extends BaseException {
    public OrganizationFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
