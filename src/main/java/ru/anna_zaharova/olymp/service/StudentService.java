package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.student.EditStudentRequest;
import ru.anna_zaharova.olymp.rest.dto.request.student.NewStudentRequest;
import ru.anna_zaharova.olymp.rest.dto.response.student.StudentDto;

public interface StudentService {
    Long addNewStudent(NewStudentRequest request);

    StudentDto edit(Long id, EditStudentRequest request);

    void deleteById(Long id);

    StudentDto findById(Long id);
}
