package ru.anna_zaharova.olymp.service;


import ru.anna_zaharova.olymp.rest.dto.request.electivecourse.EditElectiveCourseRequest;
import ru.anna_zaharova.olymp.rest.dto.request.electivecourse.NewElectiveCourseRequest;
import ru.anna_zaharova.olymp.rest.dto.response.electiveCourse.ElectiveCourseDto;

public interface ElectiveCourseService {
    Long addNewElectiveCourse(NewElectiveCourseRequest request);

    ElectiveCourseDto edit(Long id, EditElectiveCourseRequest request);

    void deleteById(Long id);

    ElectiveCourseDto findById(Long id);
}
