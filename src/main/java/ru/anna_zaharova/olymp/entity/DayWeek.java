package ru.anna_zaharova.olymp.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "day_week")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayWeek extends AbstractEntity{
    @Column(name = "name", length = 11, nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "busyDay")
    private List<ElectiveCourse> electiveCourses;
}
