package ru.anna_zaharova.olymp.rest.dto.request.dayweek;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewDayWeekRequest {
    private String name;
}
