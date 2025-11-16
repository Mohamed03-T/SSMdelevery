/*
 *
 *  * @project : SSMDelivery
 *  * @created : 13/05/2024, 17:20
 *  * @modified : 13/05/2024, 17:20
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ArgumentNotValidDto {
    boolean success;
    String message;
    Object errors;
}



