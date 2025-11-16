
/*
 *
 *  * @project : SSMDelivery
 *  * @created : 16/05/2024, 17:50
 *  * @modified : 16/05/2024, 17:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}


