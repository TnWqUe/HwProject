package ru.anna_zaharova.olymp.rest.dto.response.olympLevel;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OlympLevelDto {
    private String name;
    private List<Long> olympToursIds;
}
