/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 30/04/2024, 19:15
 *  * @modified : 30/04/2024, 19:15
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller.test;

import com.fsdm.pfe.ssmdelivery.service.Impl.AddressServiceImpl;
import com.fsdm.pfe.ssmdelivery.service.Impl.CustomerServiceImpl;
import com.fsdm.pfe.ssmdelivery.service.Impl.DeliveryAddressServiceImpl;
import com.fsdm.pfe.ssmdelivery.service.Impl.ParcelServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class parcelTest {

    AddressServiceImpl addressService;
    DeliveryAddressServiceImpl deliveryAddressService;
    CustomerServiceImpl customerService;
    ParcelServiceImpl parcelService;

    public parcelTest(AddressServiceImpl addressService, DeliveryAddressServiceImpl deliveryAddressService, CustomerServiceImpl customerService, ParcelServiceImpl parcelService) {
        this.addressService = addressService;
        this.deliveryAddressService = deliveryAddressService;
        this.customerService = customerService;
        this.parcelService = parcelService;
    }


}



