package ru.anna_zaharova.olymp.rest.dto.team;

import lombok.Data;

import java.util.List;

@Data
public class EditTeamRequest {
    private String name;
    private Long teacherId;
    private List<Long> studentsId;
    private List<Long> olympToursId;
}
