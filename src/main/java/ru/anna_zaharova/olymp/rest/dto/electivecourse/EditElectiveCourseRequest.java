package ru.anna_zaharova.olymp.rest.dto.electivecourse;

import ru.anna_zaharova.olymp.entity.DayWeek;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EditElectiveCourseRequest {
    private String name;
    private LocalDate beginDate;
    private LocalDateTime beginTime;
    private String cabinet;
    private String description;
    private DayWeek dayWeekId;
    private List<Long> studentsId;
    private List<Long> olympToursId;
}
