package ru.anna_zaharova.olymp.exception.exceptions.dayweek;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DayWeekNotFoundException  extends BaseException {
    public DayWeekNotFoundException(String message)  {
        super(HttpStatus.NOT_FOUND,message);
    }
}
