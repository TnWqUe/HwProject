package ru.anna_zaharova.olymp.exception.exceptions.organization;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class OrganizationNotFoundException extends BaseException {
    public OrganizationNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
