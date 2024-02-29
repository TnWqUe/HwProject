package ru.anna_zaharova.olymp.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "orgn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orgn extends AbstractEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;
}
