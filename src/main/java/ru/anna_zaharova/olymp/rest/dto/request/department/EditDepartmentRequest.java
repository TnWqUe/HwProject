package ru.anna_zaharova.olymp.rest.dto.request.department;

import lombok.Data;


@Data
public class EditDepartmentRequest {
    private String name;
    private Long parentId;
}
