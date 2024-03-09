package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.olymptour.EditOlympTourRequest;
import ru.anna_zaharova.olymp.rest.dto.request.olymptour.NewOlympTourRequest;
import ru.anna_zaharova.olymp.rest.dto.response.olympTour.OlympTourDto;

public interface OlympTourService {
    Long addNewOlympTour(NewOlympTourRequest request);

    OlympTourDto edit(Long id, EditOlympTourRequest request);

    void deleteById(Long id);

    OlympTourDto findById(Long id);
}
