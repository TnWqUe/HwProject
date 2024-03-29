package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.AbstractEntity;
import ru.anna_zaharova.olymp.entity.Department;
import ru.anna_zaharova.olymp.exception.exceptions.department.DepartmentFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.department.DepartmentNotFoundException;
import ru.anna_zaharova.olymp.exception.exceptions.organization.OrganizationNotFoundException;
import ru.anna_zaharova.olymp.repo.DepartmentRepo;
import ru.anna_zaharova.olymp.repo.OrganizationRepo;
import ru.anna_zaharova.olymp.rest.dto.request.department.EditDepartmentRequest;
import ru.anna_zaharova.olymp.rest.dto.request.department.NewDepartmentRequest;
import ru.anna_zaharova.olymp.rest.dto.response.department.DepartmentDto;
import ru.anna_zaharova.olymp.service.DepartmentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final OrganizationRepo organizationRepo;

    @Override
    public Long addNewDepartment(NewDepartmentRequest request) {
        if (!StringUtils.hasText(request.getName()) || request.getParentId() == null) {
            throw new DepartmentFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        if (!organizationRepo.existsById(request.getParentId())) {
            throw new OrganizationNotFoundException("Не найдена организация с id = " + request.getParentId());
        }

        Department department = new Department();
        department.setName(request.getName());
        departmentRepo.saveAndFlush(department);
        return department.getId();
    }

    @Override
    public DepartmentDto edit(Long id, EditDepartmentRequest request) {

        Optional<Department> departmentFromDb = departmentRepo.findById(id);

        if (departmentFromDb.isEmpty()) {
            throw new DepartmentFieldsEmptyException("Не найден отдел с id = " + id);
        }

        if (!StringUtils.hasText(request.getName()) || request.getParentId() == null) {
            throw new DepartmentFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        if (!organizationRepo.existsById(request.getParentId())) {
            throw new OrganizationNotFoundException("Невозможно изменить отдел, так как некорректно введен id organization = " + request.getParentId());
        }
/*
        Department department = Department.builder()
                .name(request.getName())
                .parent(organizationRepo.findById(request.getParentId()).get())
                .students(departmentFromDb.get().getStudents())
                .build();
        department.setId(id);*/
        Department department =departmentFromDb.get();
        department.setName(request.getName());
        department.setParent(organizationRepo.findById(request.getParentId()).get());
        departmentRepo.save(department);
        return buildDto(department);
    }

    @Override
    public void deleteById(Long id) {
        if (!departmentRepo.existsById(id)) {
            throw new DepartmentNotFoundException("Не найден отдел с id = " + id);
        }
        departmentRepo.deleteById(id);
    }

    @Override
    public DepartmentDto findById(Long id) {
        Optional<Department> departmentFromDb = departmentRepo.findById(id);
        if (departmentFromDb.isEmpty()) {
            throw new DepartmentNotFoundException("Не найден отдел с id = " + id);
        }
        Department department = departmentFromDb.get();
        return buildDto(department);
    }

    private DepartmentDto buildDto(Department department) {

        DepartmentDto departmentDto = DepartmentDto.builder().name(department.getName()).parentId(department.getParent().getId()).build();

        if (department.getStudents() != null) {
            List<Long> studentsIds = department.getStudents().stream().map(AbstractEntity::getId).collect(Collectors.toList());
            departmentDto.setStudentsIds(studentsIds);
        }

        return departmentDto;
    }
}
