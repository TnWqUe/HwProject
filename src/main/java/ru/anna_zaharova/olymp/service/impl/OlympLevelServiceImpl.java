package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.AbstractEntity;
import ru.anna_zaharova.olymp.entity.OlympLevel;
import ru.anna_zaharova.olymp.exception.exceptions.olympformat.OlympFormatNotFoundException;
import ru.anna_zaharova.olymp.exception.exceptions.olymplevel.OlympLevelFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.olymplevel.OlympLevelNotFoundException;
import ru.anna_zaharova.olymp.repo.OlympLevelRepo;
import ru.anna_zaharova.olymp.rest.dto.request.olympLevel.EditOlympLevelRequest;
import ru.anna_zaharova.olymp.rest.dto.request.olympLevel.NewOlympLevelRequest;
import ru.anna_zaharova.olymp.rest.dto.response.olympLevel.OlympLevelDto;
import ru.anna_zaharova.olymp.service.OlympLevelService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OlympLevelServiceImpl implements OlympLevelService {
    private final OlympLevelRepo olympLevelRepo;

    @Override
    public Long addNewOlympLevel(NewOlympLevelRequest request) {

        if (!StringUtils.hasText(request.getName())) {
            throw new OlympLevelFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        OlympLevel olympLevel = new OlympLevel();
        olympLevel.setName(request.getName());
        olympLevelRepo.saveAndFlush(olympLevel);
        return olympLevel.getId();
    }

    @Override
    public OlympLevelDto edit(Long id, EditOlympLevelRequest request) {

        Optional<OlympLevel> olympLevelFromDb = olympLevelRepo.findById(id);

        if (olympLevelFromDb.isEmpty()) {
            throw new OlympLevelNotFoundException("Не найден олимпиадный уровень с id = " + id);
        }

        if (!StringUtils.hasText(request.getName())) {
            throw new OlympLevelFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        /*OlympLevel olympLevel = OlympLevel.builder()
                .name(request.getName())
                .olympTours(olympLevelFromDb.get().getOlympTours())
                .build();*/
        OlympLevel olympLevel = olympLevelFromDb.get();
        olympLevel.setName(request.getName());
        olympLevelRepo.save(olympLevel);
        return buildDto(olympLevel);
    }

    @Override
    public void deleteById(Long id) {
        if (!olympLevelRepo.existsById(id)) {
            throw new OlympLevelNotFoundException("Не найден олимпиадный уровень с id = " + id);
        }
        olympLevelRepo.deleteById(id);
    }

    @Override
    public OlympLevelDto findById(Long id) {

        Optional<OlympLevel> olympLevelFromDb = olympLevelRepo.findById(id);
        if (olympLevelFromDb.isEmpty()) {
            throw new OlympFormatNotFoundException("Не найден олимпиадный уровень с id = " + id);
        }
        OlympLevel olympLevel = olympLevelFromDb.get();
        return buildDto(olympLevel);
    }

    private OlympLevelDto buildDto(OlympLevel olympLevel) {
        OlympLevelDto olympLevelDto = OlympLevelDto.builder()
                .name(olympLevel.getName())
                .build();

        if (olympLevel.getOlympTours() != null) {
            List<Long> olympToursIds = olympLevel.getOlympTours().stream()
                    .map(AbstractEntity::getId)
                    .collect(Collectors.toList());
            olympLevelDto.setOlympToursIds(olympToursIds);
        }

        return olympLevelDto;
    }
}
