/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 23/04/2024, 18:18
 *  * @modified : 23/04/2024, 18:15
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.model.enums;

import lombok.Getter;

@Getter
public enum ParcelStatus {
    IN_TRANSIT,
    DELIVERED,
    RETURNED,
    LOST,
    CANCELED,
    DELETED,
    PENDING
}



