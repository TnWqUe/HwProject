package ru.anna_zaharova.olymp.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends AbstractEntity{
    @Column(name = "mpei_url", length = 200, nullable = false)
    private String mpeiUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "leader")
    private List<Team> teams;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "teacher_elective_course",
            inverseJoinColumns = @JoinColumn(name = "id_teacher"),
            joinColumns = @JoinColumn(name = "id_elective_course")
    )
    private List<ElectiveCourse> electiveCourses;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "id_usr")
    private User user;
}
