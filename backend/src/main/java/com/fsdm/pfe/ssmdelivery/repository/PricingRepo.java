/*
 *
 *  * @project : SSMDelivery
 *  * @created : 20/05/2024, 21:47
 *  * @modified : 20/05/2024, 21:47
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PricingRepo extends JpaRepository<Pricing, Long> {
    Pricing findPricingById(Long id);

    Optional<Pricing> findTopByOrderByIdDesc();

}


