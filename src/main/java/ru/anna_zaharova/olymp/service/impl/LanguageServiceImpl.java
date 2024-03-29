package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.AbstractEntity;
import ru.anna_zaharova.olymp.entity.Language;
import ru.anna_zaharova.olymp.exception.exceptions.department.DepartmentFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.language.LanguageFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.language.LanguageNotFoundException;
import ru.anna_zaharova.olymp.repo.LanguageRepo;
import ru.anna_zaharova.olymp.rest.dto.request.language.EditLanguageRequest;
import ru.anna_zaharova.olymp.rest.dto.request.language.NewLanguageRequest;
import ru.anna_zaharova.olymp.rest.dto.response.language.LanguageDto;
import ru.anna_zaharova.olymp.service.LanguageService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepo languageRepo;

    @Override
    public Long addNewLanguage(NewLanguageRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new DepartmentFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        Language language = new Language();
        language.setName(request.getName());
        languageRepo.saveAndFlush(language);
        return language.getId();
    }

    @Override
    public LanguageDto edit(Long id, EditLanguageRequest request) {
        Optional<Language> languageFromDb = languageRepo.findById(id);

        if (languageFromDb.isEmpty()) {
            throw new LanguageNotFoundException("Не найден язык с id = " + id);
        }

        if (!StringUtils.hasText(request.getName())) {
            throw new LanguageFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }


        /*Language language = Language.builder()
                .name(request.getName())
                .olympTours(languageFromDb.get().getOlympTours())
                .build();*/
        Language language = languageFromDb.get();
        language.setName(request.getName());
        languageRepo.save(language);
        return buildDto(language);
    }

    @Override
    public void deleteById(Long id) {
        if (!languageRepo.existsById(id)) {
            throw new LanguageNotFoundException("Не найден язык с id = " + id);
        }
        languageRepo.deleteById(id);
    }

    @Override
    public LanguageDto findById(Long id) {
        Optional<Language> languageFromDb = languageRepo.findById(id);
        if (languageFromDb.isEmpty()) {
            throw new LanguageNotFoundException("Не найден язык с id = " + id);
        }
        Language language = languageFromDb.get();
        return buildDto(language);
    }

    private LanguageDto buildDto(Language language) {

        LanguageDto languageDto = LanguageDto.builder()
                .name(language.getName())
                .build();

        if (language.getOlympTours() != null) {
            List<Long> olympToursIds = language.getOlympTours().stream()
                    .map(AbstractEntity::getId)
                    .collect(Collectors.toList());
            languageDto.setOlympToursIds(olympToursIds);
            ;
        }

        return languageDto;
    }
}
