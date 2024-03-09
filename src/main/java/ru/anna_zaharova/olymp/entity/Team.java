package ru.anna_zaharova.olymp.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team extends AbstractEntity{
    @Column(name = "name", length = 200, nullable = false)
    private String name;
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Column(name = "description", length = 512)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    private Teacher leader;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "team_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_team"),
            joinColumns = @JoinColumn(name = "id_olymp_tour")
    )
    private List<OlympTour> olympTours;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stud_team",
            inverseJoinColumns = @JoinColumn(name = "id_team"),
            joinColumns = @JoinColumn(name = "id_stud")
    )
    private List<Student> students;
}