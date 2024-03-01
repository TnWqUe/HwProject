package ru.anna_zaharova.olymp.rest.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewUserRequest {
    private String email;
    private String surname;
    private String usrname;
    private String patronymic;
    private String password;
}
