package ru.anna_zaharova.olymp.rest.dto.request.organization;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewOrganizationRequest {
    private String name;
}
