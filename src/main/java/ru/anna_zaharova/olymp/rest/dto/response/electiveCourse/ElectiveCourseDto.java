package ru.anna_zaharova.olymp.rest.dto.response.electiveCourse;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ElectiveCourseDto {
    private String name;
    private LocalDate beginDate;
    private LocalDateTime beginTime;
    private String cabinet;
    private String description;
    private String dayWeekName;
    private List<Long> studentsId;
    private List<Long> olympToursId;
    private List<Long> disciplinesIds;
    private List<Long> teachersIds;
}
