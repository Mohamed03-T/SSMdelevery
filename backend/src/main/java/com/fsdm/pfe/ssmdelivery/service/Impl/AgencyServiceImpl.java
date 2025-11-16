
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 25/04/2024, 20:28
 *  * @modified : 25/04/2024, 20:28
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service.Impl;

import com.fsdm.pfe.ssmdelivery.dto.request.AgencyRequestDto;
import com.fsdm.pfe.ssmdelivery.dto.response.AgencyResponseDto;
import com.fsdm.pfe.ssmdelivery.entity.Address;
import com.fsdm.pfe.ssmdelivery.entity.Agency;
import com.fsdm.pfe.ssmdelivery.entity.Area;
import com.fsdm.pfe.ssmdelivery.model.MapsLocationPoint;
import com.fsdm.pfe.ssmdelivery.repository.AgencyRepo;
import com.fsdm.pfe.ssmdelivery.service.AgencyService;
import com.fsdm.pfe.ssmdelivery.service.Impl.location.AreaServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    private final AddressServiceImpl addressService;
    private final AreaServiceImpl areaService;
    private final AgencyRepo agencyRepository;

    public AgencyServiceImpl(AddressServiceImpl addressService, AreaServiceImpl areaService, AgencyRepo agencyRepository) {
        this.addressService = addressService;
        this.areaService = areaService;
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }

    @Override
    public Agency loadAgencyById(Long id) {
        return agencyRepository.findById(id).orElse(null);
    }

    @Override
    public Agency saveAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Transactional
    public Agency saveNewAgency(AgencyRequestDto agencyRequestDto) {

        Area area = areaService.loadByCode(agencyRequestDto.getAgencyAddress().getAreaCode());

        if (area == null) {
            throw new IllegalArgumentException("Area with code " + agencyRequestDto.getAgencyAddress().getAreaCode() + " not found");
        }

        Address address = new Address();
        address.setAddress(agencyRequestDto.getAgencyAddress().getAddress());
        address.setArea(area);

        address = addressService.saveAddress(address);

        Agency agency = new Agency();
        agency.setAgencyName(agencyRequestDto.getAgencyName());
        agency.setAgencyAddress(address);
        agency.setAgencyContactNumber(agencyRequestDto.getAgencyContactNumber());
        agency.setAgencyEmail(agencyRequestDto.getAgencyEmail());
        agency.setLocationPoint(new MapsLocationPoint(agencyRequestDto.getLocationPoint().getLatitude(),
                agencyRequestDto.getLocationPoint().getLongitude()));

        return agencyRepository.save(agency);
    }


    @Override
    public Agency updateAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }


    public AgencyResponseDto convertEntityToResponseDto(Agency agency) {
        return new AgencyResponseDto(agency);
    }

    public List<AgencyResponseDto> convertEntityListToResponseDtoList(List<Agency> agencies) {
        return agencies.stream().map(this::convertEntityToResponseDto).toList();
    }


}



