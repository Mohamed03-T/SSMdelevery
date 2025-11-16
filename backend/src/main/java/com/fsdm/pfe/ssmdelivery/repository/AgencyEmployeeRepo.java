/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 25/04/2024, 14:50
 *  * @modified : 25/04/2024, 14:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.AgencyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyEmployeeRepo extends JpaRepository<AgencyEmployee, Long> {
}



