package ru.anna_zaharova.olymp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "discipline")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discipline extends AbstractEntity{
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "elective_course_discipline",
            inverseJoinColumns = @JoinColumn(name = "id_discipline"),
            joinColumns = @JoinColumn(name = "id_elective_course")
    )
    private List<ElectiveCourse> electiveCourses;

}
