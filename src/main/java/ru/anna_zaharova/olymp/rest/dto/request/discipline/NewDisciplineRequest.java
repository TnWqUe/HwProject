package ru.anna_zaharova.olymp.rest.dto.request.discipline;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewDisciplineRequest {
    private String name;
}
