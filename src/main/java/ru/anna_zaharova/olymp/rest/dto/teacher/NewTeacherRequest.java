package ru.anna_zaharova.olymp.rest.dto.teacher;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewTeacherRequest {
    private String mpeiUrl;
    private Long userId;
}
