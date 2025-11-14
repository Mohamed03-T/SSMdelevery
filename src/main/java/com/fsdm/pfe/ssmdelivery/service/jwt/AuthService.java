/*
 *
 *  * @project : SSMDelivery
 *  * @created : 16/05/2024, 16:44
 *  * @modified : 16/05/2024, 16:44
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.jwt;

import com.fsdm.pfe.ssmdelivery.dto.api.authentication.AuthenticationRequestDto;
import com.fsdm.pfe.ssmdelivery.dto.api.authentication.AuthenticationResponseDto;

public interface AuthService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto request);

}



