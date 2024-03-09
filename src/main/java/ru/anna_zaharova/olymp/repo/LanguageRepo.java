package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anna_zaharova.olymp.entity.Language;

import java.util.Optional;

public interface LanguageRepo extends JpaRepository<Language, Long> {
    Optional<Language> findById(Long id);
    // существует ли язык олимпиады с таким id
    boolean existsById(Long id);
}
