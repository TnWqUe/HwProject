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
@Table(name = "discipline")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
