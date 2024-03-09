package ru.anna_zaharova.olymp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dept")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department extends AbstractEntity{
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_orgn")
    private Organization parent;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    private List<Student> students;
}
