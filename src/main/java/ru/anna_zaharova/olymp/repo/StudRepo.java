package ru.anna_zaharova.olymp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anna_zaharova.olymp.entity.Stud;


@Repository
public interface StudRepo extends JpaRepository<Stud, Long> {

}