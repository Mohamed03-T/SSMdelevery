/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 04/05/2024, 18:17
 *  * @modified : 04/05/2024, 18:17
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import com.fsdm.pfe.ssmdelivery.model.MapsLocationPoint;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.fsdm.pfe.ssmdelivery.model.MapsLocationPoint}
 */
@Value
public class MapsLocationPointDto implements Serializable {
    Double latitude;
    Double longitude;

    public MapsLocationPointDto(MapsLocationPoint point) {
        this.latitude = point.getLatitude();
        this.longitude = point.getLongitude();
    }
}


