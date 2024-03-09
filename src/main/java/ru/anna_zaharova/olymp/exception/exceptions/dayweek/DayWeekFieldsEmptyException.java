package ru.anna_zaharova.olymp.exception.exceptions.dayweek;

import org.springframework.http.HttpStatus;
import ru.anna_zaharova.olymp.exception.exceptions.common.BaseException;

public class DayWeekFieldsEmptyException  extends BaseException {
    public DayWeekFieldsEmptyException(String message) {super(HttpStatus.BAD_REQUEST, message);}
}
