/*
 *
 *  * @project : SSMDelivery
 *  * @created : 11/05/2024, 14:17
 *  * @modified : 11/05/2024, 14:17
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.location;

import com.fsdm.pfe.ssmdelivery.entity.Area;

import java.util.List;

public interface AreaService {
    Area create(Area area);

    Area update(Area area);

    Area loadById(Long id);

    Area loadByCode(String code);

    List<Area> loadAll();

    void delete(Long id);

    void deleteByCode(String code);

    List<Area> saveAll(List<Area> areas);

    List<Area> loadByCityCode(String cityCode);
}



