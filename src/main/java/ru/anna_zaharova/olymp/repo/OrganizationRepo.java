package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anna_zaharova.olymp.entity.Organization;

import java.util.Optional;

public interface OrganizationRepo extends JpaRepository<Organization, Long> {
    Optional<Organization> findById(Long id);
    // существует ли организация с таким id
    boolean existsById(Long id);
}
