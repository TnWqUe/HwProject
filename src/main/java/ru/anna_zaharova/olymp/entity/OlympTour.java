package ru.anna_zaharova.olymp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "olymp_tour")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OlympTour extends AbstractEntity{
    @Column(name = "name", length = 250, nullable = false)
    private String name;
    @Column(name = "olymp_url", length = 200, nullable = false)
    private String olympUrl;
    @Column(name = "organizer", length = 250, nullable = false)
    private String organizer;
    @Column(name = "tours_amount", nullable = false)
    private Integer toursAmount;
    @Column(name = "tour_number", nullable = false)
    private Integer tourNumber;
    @Column(name = "start_reg")
    private LocalDate startReg;
    @Column(name = "end_reg")
    private LocalDate endReg;
    @Column(name = "is_open_for_requests")
    private Boolean isOpenForRequests;
    @Column(name = "begin_tour", nullable = false)
    private LocalDate beginTour;
    @Column(name = "end_tour", nullable = false)
    private LocalDate endTour;
    @Column(name = "address", length = 512, nullable = false)
    private String address;
    @Column(name = "comment_text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_olymp_level")
    private OlympLevel level;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_olymp_format")
    private OlympFormat format;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_olymp_tour"),
            joinColumns = @JoinColumn(name = "id_team")
    )
    private List<Team> teams;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "lang_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_olymp_tour"),
            joinColumns = @JoinColumn(name = "id_lang")
    )
    private List<Lang> languages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "elective_course_olymp_tour",
            inverseJoinColumns = @JoinColumn(name = "id_olymp_tour"),
            joinColumns = @JoinColumn(name = "id_elective_course")
    )
    private List<ElectiveCourse> electiveCourses;


}