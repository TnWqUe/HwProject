package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.AbstractEntity;
import ru.anna_zaharova.olymp.entity.OlympFormat;
import ru.anna_zaharova.olymp.exception.exceptions.olympformat.OlympFormatFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.olympformat.OlympFormatNotFoundException;
import ru.anna_zaharova.olymp.repo.OlympFormatRepo;
import ru.anna_zaharova.olymp.rest.dto.request.olympformat.EditOlympFormatRequest;
import ru.anna_zaharova.olymp.rest.dto.request.olympformat.NewOlympFormatRequest;
import ru.anna_zaharova.olymp.rest.dto.response.olympFormat.OlympFormatDto;
import ru.anna_zaharova.olymp.service.OlympFormatService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OlympFormatServiceImpl implements OlympFormatService {
    private final OlympFormatRepo olympFormatRepo;

    @Override
    public Long addNewOlympFormat(NewOlympFormatRequest request) {

        if (!StringUtils.hasText(request.getName())) {
            throw new OlympFormatFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        OlympFormat olympFormat = new OlympFormat();
        olympFormat.setName(request.getName());
        olympFormatRepo.saveAndFlush(olympFormat);
        return olympFormat.getId();
    }

    @Override
    public OlympFormatDto edit(Long id, EditOlympFormatRequest request) {

        Optional<OlympFormat> olympFormatFromDb = olympFormatRepo.findById(id);

        if (olympFormatFromDb.isEmpty()) {
            throw new OlympFormatNotFoundException("Не найден олимпиадный формат с id = " + id);
        }

        if (!StringUtils.hasText(request.getName())) {
            throw new OlympFormatFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        /*OlympFormat olympFormat = OlympFormat.builder()
                .name(request.getName())
                .olympTours(olympFormatFromDb.get().getOlympTours())
                .build();*/
        OlympFormat olympFormat = new OlympFormat();
        olympFormat.setName(request.getName());
        olympFormatRepo.save(olympFormat);
        return buildDto(olympFormat);
    }

    @Override
    public void deleteById(Long id) {
        if (!olympFormatRepo.existsById(id)) {
            throw new OlympFormatNotFoundException("Не найден олимпиадный формат с id = " + id);
        }
        olympFormatRepo.deleteById(id);
    }

    @Override
    public OlympFormatDto findById(Long id) {

        Optional<OlympFormat> olympFormatFromDb = olympFormatRepo.findById(id);
        if (olympFormatFromDb.isEmpty()) {
            throw new OlympFormatNotFoundException("Не найден олимпиадный формат с id = " + id);
        }
        OlympFormat olympFormat = olympFormatFromDb.get();
        return buildDto(olympFormat);
    }

    private OlympFormatDto buildDto(OlympFormat olympFormat) {
        OlympFormatDto olympFormatDto = OlympFormatDto.builder()
                .name(olympFormat.getName())
                .build();

        if (olympFormat.getOlympTours() != null) {
            List<Long> olympToursIds = olympFormat.getOlympTours().stream()
                    .map(AbstractEntity::getId)
                    .collect(Collectors.toList());
            olympFormatDto.setOlympToursIds(olympToursIds);
        }

        return olympFormatDto;
    }
}
