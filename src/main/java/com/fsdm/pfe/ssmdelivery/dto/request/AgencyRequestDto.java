
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

import com.fsdm.pfe.ssmdelivery.util.Constants;
import jakarta.validation.Valid;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * DTO for {@link com.fsdm.pfe.ssmdelivery.entity.Agency}
 */
@Value
public class AgencyRequestDto implements Serializable {
    Long id;

    @NotBlank
    @NotNull
    String agencyName;

    @Valid
    AddressRequestDto agencyAddress;

    @Pattern(regexp = Constants.MOROCCAN_NUMBER_REGEXP)
    String agencyContactNumber;

    @NotNull
    String agencyEmail;

    @Valid
    MapsLocationPointRequestDto locationPoint;
}


