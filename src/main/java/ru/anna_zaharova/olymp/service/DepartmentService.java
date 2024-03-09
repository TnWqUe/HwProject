package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.department.EditDepartmentRequest;
import ru.anna_zaharova.olymp.rest.dto.request.department.NewDepartmentRequest;
import ru.anna_zaharova.olymp.rest.dto.response.department.DepartmentDto;

public interface DepartmentService {
    Long addNewDepartment(NewDepartmentRequest request);

    DepartmentDto edit(Long id, EditDepartmentRequest request);

    void deleteById(Long id);

    DepartmentDto findById(Long id);
}
