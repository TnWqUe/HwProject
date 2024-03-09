package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.Student;

import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
    // существует ли пользователь с таким id
    boolean existsById(Long id);
}