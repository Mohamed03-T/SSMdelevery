/*
 *
 *  * @project : SSMDelivery
 *  * @created : 20/05/2024, 21:25
 *  * @modified : 20/05/2024, 21:25
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Value
@Builder
@AllArgsConstructor
public class ParcelVolume {
    float height;
    float width;
    float length;

    public float getVolume() {
        return height * width * length;
    }
}



