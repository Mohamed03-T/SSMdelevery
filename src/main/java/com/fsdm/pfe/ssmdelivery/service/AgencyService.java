/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 19:23
 *  * @modified : 01/05/2024, 19:23
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.Agency;

import java.util.List;

public interface AgencyService {
    void deleteAgency(Long id);

    Agency loadAgencyById(Long id);

    Agency saveAgency(Agency agency);

    Agency updateAgency(Agency agency);

    List<Agency> getAllAgencies();
}



