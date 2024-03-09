package ru.anna_zaharova.olymp.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orgn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Organization extends AbstractEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Department> departments;
}
