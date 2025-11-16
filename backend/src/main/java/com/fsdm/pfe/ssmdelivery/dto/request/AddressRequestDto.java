

/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 29/04/2024, 19:57
 *  * @modified : 29/04/2024, 19:57
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.fsdm.pfe.ssmdelivery.entity.Address}
 */
@Value
public class AddressRequestDto implements Serializable {
    Long id;

    @NotNull
    @NotEmpty
    String address;

    @NotNull
    @NotEmpty
    @NotBlank
    String areaCode;
}


