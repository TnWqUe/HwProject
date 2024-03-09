package ru.anna_zaharova.olymp.service;


import ru.anna_zaharova.olymp.rest.dto.request.olympLevel.EditOlympLevelRequest;
import ru.anna_zaharova.olymp.rest.dto.request.olympLevel.NewOlympLevelRequest;
import ru.anna_zaharova.olymp.rest.dto.response.olympLevel.OlympLevelDto;

public interface OlympLevelService {
    Long addNewOlympLevel(NewOlympLevelRequest request);

    OlympLevelDto edit(Long id, EditOlympLevelRequest request);

    void deleteById(Long id);

    OlympLevelDto findById(Long id);
}
