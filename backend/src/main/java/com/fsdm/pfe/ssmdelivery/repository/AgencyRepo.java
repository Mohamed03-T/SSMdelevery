/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 25/04/2024, 14:47
 *  * @modified : 25/04/2024, 14:47
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgencyRepo extends JpaRepository<Agency, Long> {
}



