package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.olympformat.EditOlympFormatRequest;
import ru.anna_zaharova.olymp.rest.dto.request.olympformat.NewOlympFormatRequest;
import ru.anna_zaharova.olymp.rest.dto.response.olympFormat.OlympFormatDto;

public interface OlympFormatService {
    Long addNewOlympFormat(NewOlympFormatRequest request);

    OlympFormatDto edit(Long id, EditOlympFormatRequest request);

    void deleteById(Long id);

    OlympFormatDto findById(Long id);
}
