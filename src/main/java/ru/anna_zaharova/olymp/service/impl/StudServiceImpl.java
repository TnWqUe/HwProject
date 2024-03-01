package ru.anna_zaharova.olymp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anna_zaharova.olymp.entity.Stud;
import ru.anna_zaharova.olymp.repo.StudRepo;
import ru.anna_zaharova.olymp.service.StudService;

@Service
@RequiredArgsConstructor
public class StudServiceImpl implements StudService {

    private final StudRepo studRepo;

    @Override
    public void save(Stud stud) {
        studRepo.save(stud);
    }
}
