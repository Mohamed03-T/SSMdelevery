/*
 *
 *  * @project : SSMDelivery
 *  * @created : 11/05/2024, 14:44
 *  * @modified : 11/05/2024, 14:44
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.request;

import com.fsdm.pfe.ssmdelivery.entity.Province;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Province}
 */
@Value
@Setter
@Getter

public class ProvinceRequestDto implements Serializable {
    Long id;
    @NotNull
    String code;

    String name;
    String countryCode;
    String postalCode;
}


