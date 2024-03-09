package ru.anna_zaharova.olymp.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "elective_course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ElectiveCourse extends AbstractEntity{
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Column(name = "begin_date", nullable = false)
    private LocalDate beginDate;
    @Column(name = "begin_time", nullable = false)
    private LocalDateTime beginTime;
    @Column(name = "cabinet", length = 10, nullable = false)
    private String cabinet;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_day_week")
    private DayWeek busyDay;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "stud_elective_course",
            inverseJoinColumns = @JoinColumn(name = "id_elective_course"),
            joinColumns = @JoinColumn(name = "id_stud")
    )
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "elective_course_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_elective_course"),
            joinColumns = @JoinColumn(name = "id_olymp_tour")
    )
    private List<OlympTour> olympTours;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "teacher_elective_course",
            inverseJoinColumns = @JoinColumn(name = "id_elective_course"),
            joinColumns = @JoinColumn(name = "id_teacher")
    )
    private List<Teacher> teachers;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "elective_course_discipline",
            inverseJoinColumns = @JoinColumn(name = "id_elective_course"),
            joinColumns = @JoinColumn(name = "id_discipline")
    )
    private List<Discipline> disciplines;
}
