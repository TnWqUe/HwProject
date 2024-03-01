package ru.anna_zaharova.olymp.rest.dto.user;

import lombok.Data;

@Data
public class EditUserRequest {
    private String email;
    private String surname;
    private String usrname;
    private String patronymic;
}
