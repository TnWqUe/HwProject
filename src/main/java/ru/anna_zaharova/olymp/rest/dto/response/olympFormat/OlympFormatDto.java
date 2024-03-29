package ru.anna_zaharova.olymp.rest.dto.response.olympFormat;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OlympFormatDto {
    private String name;
    private List<Long> olympToursIds;
}
