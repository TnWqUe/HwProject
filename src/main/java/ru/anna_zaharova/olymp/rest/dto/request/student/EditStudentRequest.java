package ru.anna_zaharova.olymp.rest.dto.request.student;


import lombok.Data;
import java.util.List;

@Data
public class EditStudentRequest {
    private String studGroup;
    private Long departmentId;
    private List<Long> electiveCoursesIds;
    private List<Long> teamsIds;
}
