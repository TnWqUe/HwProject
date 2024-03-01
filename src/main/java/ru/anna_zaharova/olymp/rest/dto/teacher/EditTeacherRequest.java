package ru.anna_zaharova.olymp.rest.dto.teacher;

import lombok.Data;

import java.util.List;

@Data
public class EditTeacherRequest {
    private String mpeiUrl;
    private List<Long> teamIds;
    private List<Long> electiveCourseIds;
}
