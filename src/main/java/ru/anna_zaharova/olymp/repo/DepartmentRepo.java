package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.Department;


import java.util.Optional;

@Repository
public interface DepartmentRepo  extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
    // существует ли отдел с таким id
    boolean existsById(Long id);

}
