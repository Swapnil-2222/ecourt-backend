package com.mycompany.techvg.ecourt.service.impl;

import com.mycompany.techvg.ecourt.domain.Organization;
import com.mycompany.techvg.ecourt.repository.OrganizationRepository;
import com.mycompany.techvg.ecourt.service.OrganizationService;
import com.mycompany.techvg.ecourt.service.dto.OrganizationDTO;
import com.mycompany.techvg.ecourt.service.mapper.OrganizationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Organization}.
 */
@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public OrganizationDTO save(OrganizationDTO organizationDTO) {
        log.debug("Request to save Organization : {}", organizationDTO);
        Organization organization = organizationMapper.toEntity(organizationDTO);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO update(OrganizationDTO organizationDTO) {
        log.debug("Request to save Organization : {}", organizationDTO);
        Organization organization = organizationMapper.toEntity(organizationDTO);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }

    @Override
    public Optional<OrganizationDTO> partialUpdate(OrganizationDTO organizationDTO) {
        log.debug("Request to partially update Organization : {}", organizationDTO);

        return organizationRepository
            .findById(organizationDTO.getId())
            .map(existingOrganization -> {
                organizationMapper.partialUpdate(existingOrganization, organizationDTO);

                return existingOrganization;
            })
            .map(organizationRepository::save)
            .map(organizationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrganizationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Organizations");
        return organizationRepository.findAll(pageable).map(organizationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrganizationDTO> findOne(Long id) {
        log.debug("Request to get Organization : {}", id);
        return organizationRepository.findById(id).map(organizationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Organization : {}", id);
        organizationRepository.deleteById(id);
    }
}
