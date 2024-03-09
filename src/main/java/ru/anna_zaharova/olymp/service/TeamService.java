package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.team.EditTeamRequest;
import ru.anna_zaharova.olymp.rest.dto.request.team.NewTeamRequest;
import ru.anna_zaharova.olymp.rest.dto.response.team.TeamDto;

public interface TeamService {
    Long addNewTeam(NewTeamRequest request);

    TeamDto edit(Long id, EditTeamRequest request);

    void deleteById(Long id);

    TeamDto findById(Long id);
}
