package ru.anna_zaharova.olymp.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String surname;
    private String usrname;
    private String patronymic;
    private String email;
}
