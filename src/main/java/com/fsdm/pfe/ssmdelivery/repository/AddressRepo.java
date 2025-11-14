/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 27/04/2024, 15:25
 *  * @modified : 27/04/2024, 15:25
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}




