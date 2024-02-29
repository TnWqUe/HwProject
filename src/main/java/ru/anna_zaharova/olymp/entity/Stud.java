package ru.anna_zaharova.olymp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stud")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stud extends AbstractEntity{
    @Column(name = "stud_group", length = 15, nullable = false)
    private String studGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept")
    private Dept parent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "stud_elective_course",
            inverseJoinColumns = @JoinColumn(name = "id_stud"),
            joinColumns = @JoinColumn(name = "id_elective_course")
    )
    private List<ElectiveCourse> electiveCourses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "stud_team",
            inverseJoinColumns = @JoinColumn(name = "id_stud"),
            joinColumns = @JoinColumn(name = "id_team")
    )
    private List<Team> teams;
}
