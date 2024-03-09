package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.Teacher;

import java.util.Optional;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findById(Long id);
    // существует ли пользователь с таким id
    boolean existsById(Long id);
}