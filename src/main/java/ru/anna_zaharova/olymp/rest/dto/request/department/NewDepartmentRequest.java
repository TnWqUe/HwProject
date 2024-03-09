package ru.anna_zaharova.olymp.rest.dto.request.department;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewDepartmentRequest {
    private String name;
    private Long parentId;
}
