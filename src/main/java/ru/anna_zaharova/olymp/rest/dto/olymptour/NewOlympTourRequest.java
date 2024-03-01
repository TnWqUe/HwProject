package ru.anna_zaharova.olymp.rest.dto.olymptour;

import lombok.Builder;
import lombok.Data;
import ru.anna_zaharova.olymp.entity.OlympLevel;

@Data
@Builder
public class NewOlympTourRequest {
    private String name;
    private Long teacherId;
    private String description;
    private Long olympLevelId;
    private Long olympFormatId;
}
