/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 21:03
 *  * @modified : 04/06/2024, 21:03
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.Impl.datamigration.datatypes;

import com.fsdm.pfe.ssmdelivery.entity.Province;
import com.fsdm.pfe.ssmdelivery.repository.ProvinceRepo;
import com.fsdm.pfe.ssmdelivery.service.datamegration.DataWriter;

public class ProvinceDataWriter implements DataWriter<Province> {
    private final ProvinceRepo provinceRepo;

    public ProvinceDataWriter(ProvinceRepo provinceRepo) {
        this.provinceRepo = provinceRepo;
    }

    @Override
    public void writeDataToDatabase(Province data) {

    }
}



