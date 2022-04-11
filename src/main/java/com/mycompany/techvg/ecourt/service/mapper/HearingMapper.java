package com.mycompany.techvg.ecourt.service.mapper;

import com.mycompany.techvg.ecourt.domain.CourtCase;
import com.mycompany.techvg.ecourt.domain.Hearing;
import com.mycompany.techvg.ecourt.service.dto.CourtCaseDTO;
import com.mycompany.techvg.ecourt.service.dto.HearingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Hearing} and its DTO {@link HearingDTO}.
 */
@Mapper(componentModel = "spring")
public interface HearingMapper extends EntityMapper<HearingDTO, Hearing> {
    @Mapping(target = "courtCase", source = "courtCase", qualifiedByName = "courtCaseLandReferenceNo")
    HearingDTO toDto(Hearing s);

    @Named("courtCaseLandReferenceNo")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "landReferenceNo", source = "landReferenceNo")
    CourtCaseDTO toDtoCourtCaseLandReferenceNo(CourtCase courtCase);
}
