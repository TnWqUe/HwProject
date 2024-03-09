package ru.anna_zaharova.olymp.service;

import ru.anna_zaharova.olymp.rest.dto.request.organization.EditOrganizationRequest;
import ru.anna_zaharova.olymp.rest.dto.request.organization.NewOrganizationRequest;
import ru.anna_zaharova.olymp.rest.dto.response.organization.OrganizationDto;

public interface OrganizationService {
    Long addNewOrganization(NewOrganizationRequest request);

    OrganizationDto edit(Long id, EditOrganizationRequest request);

    void deleteById(Long id);

    OrganizationDto findById(Long id);
}
