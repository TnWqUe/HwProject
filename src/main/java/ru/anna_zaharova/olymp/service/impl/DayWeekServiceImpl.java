package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.anna_zaharova.olymp.entity.AbstractEntity;
import ru.anna_zaharova.olymp.entity.DayWeek;
import ru.anna_zaharova.olymp.entity.User;
import ru.anna_zaharova.olymp.exception.exceptions.dayweek.DayWeekFieldsEmptyException;
import ru.anna_zaharova.olymp.exception.exceptions.dayweek.DayWeekNotFoundException;
import ru.anna_zaharova.olymp.repo.DayWeekRepo;
import ru.anna_zaharova.olymp.rest.dto.request.dayweek.EditDayWeekRequest;
import ru.anna_zaharova.olymp.rest.dto.request.dayweek.NewDayWeekRequest;
import ru.anna_zaharova.olymp.rest.dto.response.dayweek.DayWeekDto;
import ru.anna_zaharova.olymp.service.DayWeekService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DayWeekServiceImpl implements DayWeekService {
    private final DayWeekRepo dayWeekRepo;

    @Override
    public String addNewDayWeek(NewDayWeekRequest request) {
        if (!StringUtils.hasText(request.getName())) {
            throw new DayWeekFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

        DayWeek dayWeek = new DayWeek();
        dayWeek.setName(request.getName());
        dayWeekRepo.saveAndFlush(dayWeek);
        //return dayWeek.getId();
        return dayWeek.getName();
    }

    @Override
    public DayWeekDto edit(Long id, EditDayWeekRequest request) {

        Optional<DayWeek> dayWeekFromDb = dayWeekRepo.findById(id);

        if (dayWeekFromDb.isEmpty()) {
            throw new DayWeekNotFoundException("Не найден день недели с id = " + id);
        }

        if (!StringUtils.hasText(request.getName())) {
            throw new DayWeekFieldsEmptyException("Некорректные поля в запросе - необходимо заполнить необходимые");
        }

       /* DayWeek dayWeek = DayWeek.builder()
                .name(request.getName())
              // .electiveCourses(dayWeekFromDb.get().getElectiveCourses())
                .build();

        dayWeek.setId(id);*/
        DayWeek dayWeek = dayWeekFromDb.get();
        dayWeek.setName(request.getName());
        dayWeekRepo.save(dayWeek);
        return buildDto(dayWeek);
    }

    @Override
    public void deleteById(Long id) {
        if (!dayWeekRepo.existsById(id)) {
            throw new DayWeekNotFoundException("Не найден день недели с id = " + id);
        }
        dayWeekRepo.deleteById(id);
    }

    @Override
    public DayWeekDto findById(Long id) {
        Optional<DayWeek> dayWeekFromDb = dayWeekRepo.findById(id);
        if (dayWeekFromDb.isEmpty()) {
            throw new DayWeekNotFoundException("Не найден день недели с id = " + id);
        }
        DayWeek dayWeek = dayWeekFromDb.get();
        return buildDto(dayWeek);
    }

    private DayWeekDto buildDto(DayWeek dayWeek) {
        DayWeekDto dayWeekDto = DayWeekDto.builder().name(dayWeek.getName()).build();

        if (dayWeek.getElectiveCourses() != null) {
            List<Long> electiveCoursesIds = dayWeek.getElectiveCourses().stream().map(AbstractEntity::getId).collect(Collectors.toList());
            dayWeekDto.setElectiveCoursesIds(electiveCoursesIds);
        }

        return dayWeekDto;
    }
}
