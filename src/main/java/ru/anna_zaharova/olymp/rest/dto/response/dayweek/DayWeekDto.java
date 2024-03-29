package ru.anna_zaharova.olymp.rest.dto.response.dayweek;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DayWeekDto {
    private String name;
    private List<Long> electiveCoursesIds;
}