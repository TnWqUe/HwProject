package ru.anna_zaharova.olymp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "usr")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{
    @Column(name = "surname", nullable = false, length = 40)
    private String surname;
    @Column(name = "usrname", nullable = false, length = 40)
    private String usrname;
    @Column(name = "patronymic", nullable = false, length = 40)
    private String patronymic;
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usr_usr_role",
            inverseJoinColumns = @JoinColumn(name = "id_usr"),
            joinColumns = @JoinColumn(name = "id_usr_role")
    )
    private List<Role> roles;
}