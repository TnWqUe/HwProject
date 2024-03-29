package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.DayWeek;

import java.util.Optional;

@Repository
public interface DayWeekRepo  extends JpaRepository<DayWeek, Long> {
    Optional<DayWeek> findById(Long id);
    // существует ли день недели с таким id
    boolean existsById(Long id);
}
