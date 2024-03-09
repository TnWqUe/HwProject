package ru.anna_zaharova.olymp.service;


import ru.anna_zaharova.olymp.rest.dto.request.teacher.EditTeacherRequest;
import ru.anna_zaharova.olymp.rest.dto.request.teacher.NewTeacherRequest;
import ru.anna_zaharova.olymp.rest.dto.response.teacher.TeacherDto;

public interface TeacherService {
    Long addNewTeacher(NewTeacherRequest request);

    TeacherDto edit(Long id, EditTeacherRequest request);

    void deleteById(Long id);

    TeacherDto findById(Long id);
}
