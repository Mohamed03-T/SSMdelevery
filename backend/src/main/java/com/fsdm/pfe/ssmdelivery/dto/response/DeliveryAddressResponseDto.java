/*
 *
 *  * @project : SSMDelivery
 *  * @created : 09/05/2024, 21:38
 *  * @modified : 09/05/2024, 21:38
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import com.fsdm.pfe.ssmdelivery.entity.DeliveryAddress;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.fsdm.pfe.ssmdelivery.entity.DeliveryAddress}
 */
@Value
public class DeliveryAddressResponseDto implements Serializable {

    Long id;
    String address;
    AreaResponseDto area;
    String contactNumber;
    String contactEmail;

    public DeliveryAddressResponseDto(DeliveryAddress deliveryAddress) {
        this.area = new AreaResponseDto(deliveryAddress.getArea());
        this.contactEmail = deliveryAddress.getContactEmail();
        this.contactNumber = deliveryAddress.getContactNumber();
        this.address = deliveryAddress.getAddress();
        this.id = deliveryAddress.getId();
    }
}


