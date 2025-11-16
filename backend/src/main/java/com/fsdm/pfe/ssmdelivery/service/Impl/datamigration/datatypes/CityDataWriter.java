/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 19:40
 *  * @modified : 04/06/2024, 19:40
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.Impl.datamigration.datatypes;

import com.fsdm.pfe.ssmdelivery.entity.City;
import com.fsdm.pfe.ssmdelivery.repository.CityRepo;
import com.fsdm.pfe.ssmdelivery.service.datamegration.DataWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CityDataWriter implements DataWriter<City> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityDataWriter.class);
    private final CityRepo cityRepo;

    public CityDataWriter(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public void writeDataToDatabase(City data) {
        cityRepo.save(data);

    }
}



