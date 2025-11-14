/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 23/04/2024, 18:18
 *  * @modified : 23/04/2024, 18:16
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.model.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    DELETED,
    EXPIRED,
    LOCKED,
    EMAIL_NOT_VERIFIED,
    DISABLED
}


