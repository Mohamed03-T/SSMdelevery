/*
 *
 *  * @project : SSMDelivery
 *  * @created : 16/05/2024, 16:27
 *  * @modified : 16/05/2024, 16:27
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.api.authentication;

import lombok.Value;

@Value

public class AuthenticationRequestDto {
    String email;
    String password;
    boolean rememberMe;
}



