/*
 *
 *  * @project : SSMDelivery
 *  * @created : 20/05/2024, 21:47
 *  * @modified : 20/05/2024, 21:47
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.Pricing;

import java.util.Optional;

public interface PricingService {
    Optional<Pricing> loadPricingById(Long id);

    Optional<Pricing> loadPricingByBasePrice(double basePrice);

    void deletePricing(Long id);

    Pricing updatePricing(Pricing pricing);

    Pricing savePricing(Pricing pricing);

    Optional<Pricing> loadCurrentPricing();
}



