/*
 *
 *  * @project : SSMDelivery
 *  * @created : 18/05/2024, 20:48
 *  * @modified : 18/05/2024, 20:48
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ResetPasswordEmailRequestDto {
    @Email
    @NotNull
    String email;

    @JsonCreator
    public ResetPasswordEmailRequestDto(@JsonProperty("email") String email) {
        this.email = email;
    }
}



