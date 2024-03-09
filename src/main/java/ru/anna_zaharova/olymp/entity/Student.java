package ru.anna_zaharova.olymp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stud")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends AbstractEntity{
    @Column(name = "stud_group", length = 15, nullable = false)
    private String studGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dept")
    private Department parent;

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

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "id_usr")
    private User user;
}
