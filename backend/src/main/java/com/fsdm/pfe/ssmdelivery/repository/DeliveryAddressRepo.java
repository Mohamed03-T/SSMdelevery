/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 30/04/2024, 19:00
 *  * @modified : 30/04/2024, 19:00
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepo extends JpaRepository<DeliveryAddress, Long> {
}



