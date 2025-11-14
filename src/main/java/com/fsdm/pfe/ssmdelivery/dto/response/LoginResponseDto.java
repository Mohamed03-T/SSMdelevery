/*
 *
 *  * @project : SSMDelivery
 *  * @created : 12/05/2024, 13:29
 *  * @modified : 12/05/2024, 13:29
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Builder
public class LoginResponseDto implements Serializable {
    boolean success;
    boolean authenticated;
    String error;
    String message;
}



