package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.ElectiveCourse;
import ru.anna_zaharova.olymp.entity.OlympTour;
import ru.anna_zaharova.olymp.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectiveCourseRepo extends JpaRepository<ElectiveCourse, Long> {
    Optional<ElectiveCourse> findByName(String name);
}