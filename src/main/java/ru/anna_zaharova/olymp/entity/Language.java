package ru.anna_zaharova.olymp.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Language extends AbstractEntity{
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
