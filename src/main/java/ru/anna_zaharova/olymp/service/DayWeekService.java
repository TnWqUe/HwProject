package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.dayweek.EditDayWeekRequest;
import ru.anna_zaharova.olymp.rest.dto.request.dayweek.NewDayWeekRequest;
import ru.anna_zaharova.olymp.rest.dto.response.dayweek.DayWeekDto;

public interface DayWeekService {
    Long addNewDayWeek(NewDayWeekRequest request);

    DayWeekDto edit(Long id, EditDayWeekRequest request);

    void deleteById(Long id);

    DayWeekDto findById(Long id);
}
