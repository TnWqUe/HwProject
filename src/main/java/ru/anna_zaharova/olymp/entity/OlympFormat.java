package ru.anna_zaharova.olymp.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "olymp_format")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OlympFormat extends AbstractEntity{
    @Column(name = "name", length = 60, nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "format")
    private List<OlympTour> olympTours;
}
