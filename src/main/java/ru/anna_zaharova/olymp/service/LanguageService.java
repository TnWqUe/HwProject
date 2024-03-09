package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.language.EditLanguageRequest;
import ru.anna_zaharova.olymp.rest.dto.request.language.NewLanguageRequest;
import ru.anna_zaharova.olymp.rest.dto.response.language.LanguageDto;

public interface LanguageService {
    Long addNewLanguage(NewLanguageRequest request);

    LanguageDto edit(Long id, EditLanguageRequest request);

    void deleteById(Long id);

    LanguageDto findById(Long id);
}
