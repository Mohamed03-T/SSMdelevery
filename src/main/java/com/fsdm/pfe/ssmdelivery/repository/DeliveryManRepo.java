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

import com.fsdm.pfe.ssmdelivery.entity.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryManRepo extends JpaRepository<DeliveryMan, Long> {
    Optional<DeliveryMan> findByEmail(String email);
}



