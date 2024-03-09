package ru.anna_zaharova.olymp.exception.exceptions.department;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DepartmentNotFoundException   extends BaseException {
    public DepartmentNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
