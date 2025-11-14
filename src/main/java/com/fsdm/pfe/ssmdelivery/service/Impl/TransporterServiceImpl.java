/*
 *
 *  * @project : SSMDelivery
 *  * @created : 17/05/2024, 20:18
 *  * @modified : 17/05/2024, 20:18
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.Impl;

import com.fsdm.pfe.ssmdelivery.entity.Transporter;
import com.fsdm.pfe.ssmdelivery.model.enums.VehicleType;
import com.fsdm.pfe.ssmdelivery.repository.TransporterRepo;
import com.fsdm.pfe.ssmdelivery.service.TransporterService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransporterServiceImpl implements TransporterService {
    private final TransporterRepo transporterRepo;

    public TransporterServiceImpl(TransporterRepo transporterRepo) {
        this.transporterRepo = transporterRepo;
    }

    @Override
    public void updateTransporter(Transporter transporter) {
        transporterRepo.save(transporter);
    }

    @Override
    public void deleteTransporter(Transporter transporter) {
        transporterRepo.delete(transporter);
    }

    @Override
    public Optional<Transporter> loadByEmail(String email) {
        return transporterRepo.findByEmail(email);
    }

    @Override
    public Optional<Transporter> loadByPhoneNumber(String phoneNumber) {
        return transporterRepo.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Optional<Transporter> loadByCin(String cin) {
        return transporterRepo.findByCin(cin);
    }

    @Override
    public Optional<Transporter> loadByVehicleType(VehicleType vehicleType) {
        return transporterRepo.findByVehicleType(vehicleType);
    }


}



