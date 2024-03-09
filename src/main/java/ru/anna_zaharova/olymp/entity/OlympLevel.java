package ru.anna_zaharova.olymp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "olymp_level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OlympLevel extends AbstractEntity{
    @Column(name = "name", length = 40, nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "level")
    private List<OlympTour> olympTours;
}
