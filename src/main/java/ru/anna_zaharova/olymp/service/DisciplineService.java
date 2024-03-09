package ru.anna_zaharova.olymp.service;


import ru.anna_zaharova.olymp.rest.dto.request.discipline.EditDisciplineRequest;
import ru.anna_zaharova.olymp.rest.dto.request.discipline.NewDisciplineRequest;
import ru.anna_zaharova.olymp.rest.dto.response.discipline.DisciplineDto;

public interface DisciplineService {
    Long addNewDiscipline(NewDisciplineRequest request);

    DisciplineDto edit(Long id, EditDisciplineRequest request);

    void deleteById(Long id);

    DisciplineDto findById(Long id);
}
