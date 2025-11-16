/*
 *
 *  * @project : SSMDelivery
 *  * @created : 11/05/2024, 14:14
 *  * @modified : 11/05/2024, 14:14
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.location;

import com.fsdm.pfe.ssmdelivery.entity.Province;

import java.util.List;

public interface ProvinceService {
    Province create(Province province);

    Province update(Province province);

    Province loadById(Long id);

    Province loadByCode(String code);

    List<Province> loadAll();

    void delete(Long id);

    void deleteByCode(String code);

    List<Province> saveAll(List<Province> provinces);
}



