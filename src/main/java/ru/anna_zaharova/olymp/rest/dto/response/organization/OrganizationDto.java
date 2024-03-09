package ru.anna_zaharova.olymp.rest.dto.response.organization;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrganizationDto {
    private String name;
    private List<Long> departmentsIds;
}
