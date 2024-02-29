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
@Table(name = "dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dept extends AbstractEntity{
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orgn")
    private Orgn parent;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private List<Stud> studs;
}
