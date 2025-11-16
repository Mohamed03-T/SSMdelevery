/*
 *
 *  * @project : SSMDelivery
 *  * @created : 20/05/2024, 14:29
 *  * @modified : 20/05/2024, 14:29
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.email;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VerifyEmailTemplateDTO {
    String name;
    String actionUrl;
}



