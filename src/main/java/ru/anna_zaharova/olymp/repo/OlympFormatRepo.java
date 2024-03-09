package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anna_zaharova.olymp.entity.OlympFormat;

import java.util.Optional;

public interface OlympFormatRepo extends JpaRepository<OlympFormat, Long> {
    Optional<OlympFormat> findById(Long id);
    // существует ли олимпиадный формат с таким id
    boolean existsById(Long id);
}
