package ru.anna_zaharova.olymp.rest.dto.electivecourse;

import lombok.Builder;
import lombok.Data;
import ru.anna_zaharova.olymp.entity.DayWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class NewElectiveCourseRequest {
    private String name;
    private LocalDate beginDate;
    private LocalDateTime beginTime;
    private String cabinet;
    private String description;
    private DayWeek dayWeekId;
}
