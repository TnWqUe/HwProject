package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.teacher.NewTeacherRequest;

public interface TeacherService {
    NewTeacherRequest add(NewTeacherRequest request);

}
