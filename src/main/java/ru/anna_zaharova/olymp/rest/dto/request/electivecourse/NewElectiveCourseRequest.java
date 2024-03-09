package ru.anna_zaharova.olymp.rest.dto.request.electivecourse;

import lombok.Builder;
import lombok.Data;

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
    private Long dayWeekId;
}
