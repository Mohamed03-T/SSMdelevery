/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 29/04/2024, 20:27
 *  * @modified : 29/04/2024, 20:27
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
}


