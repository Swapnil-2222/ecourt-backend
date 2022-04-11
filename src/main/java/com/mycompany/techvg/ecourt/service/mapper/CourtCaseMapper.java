package com.mycompany.techvg.ecourt.service.mapper;

import com.mycompany.techvg.ecourt.domain.CourtCase;
import com.mycompany.techvg.ecourt.domain.Organization;
import com.mycompany.techvg.ecourt.service.dto.CourtCaseDTO;
import com.mycompany.techvg.ecourt.service.dto.OrganizationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CourtCase} and its DTO {@link CourtCaseDTO}.
 */
@Mapper(componentModel = "spring")
public interface CourtCaseMapper extends EntityMapper<CourtCaseDTO, CourtCase> {
    @Mapping(target = "organization", source = "organization", qualifiedByName = "organizationOrganizationName")
    CourtCaseDTO toDto(CourtCase s);

    @Named("organizationOrganizationName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "organizationName", source = "organizationName")
    OrganizationDTO toDtoOrganizationOrganizationName(Organization organization);
}
