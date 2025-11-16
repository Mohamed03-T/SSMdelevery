/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 29/04/2024, 20:28
 *  * @modified : 29/04/2024, 20:28
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepo extends JpaRepository<LoginLog, Long> {
}


