package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anna_zaharova.olymp.entity.Discipline;

import java.util.Optional;

public interface DisciplineRepo extends JpaRepository<Discipline, Long> {
    Optional<Discipline> findById(Long id);
    // существует ли дисциплина с таким id
    boolean existsById(Long id);
}
