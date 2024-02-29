package ru.anna_zaharova.olymp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbstractEntity{
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usr_usr_role",
            inverseJoinColumns = @JoinColumn(name = "id_usr_role"),
            joinColumns = @JoinColumn(name = "id_usr")
    )
    private List<User> users;
}
