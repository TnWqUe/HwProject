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
@Table(name = "lang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lang extends AbstractEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lang_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_lang"),
            joinColumns = @JoinColumn(name = "id_olymp_tour")
    )
    private List<OlympTour> olympTours;
}
