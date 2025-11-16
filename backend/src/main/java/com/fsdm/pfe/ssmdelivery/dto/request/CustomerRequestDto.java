
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 21:41
 *  * @modified : 01/05/2024, 21:41
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.dto.request;

import com.fsdm.pfe.ssmdelivery.model.enums.UserStatus;
import com.fsdm.pfe.ssmdelivery.util.Constants;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Value;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.fsdm.pfe.ssmdelivery.entity.Customer}
 */

@Value
public class CustomerRequestDto implements Serializable {
    Long id;

    @NotNull
    @NotEmpty
    String firstName;

    @NotNull
    @NotEmpty
    String lastName;

    @NotNull
    @Email
    @NotEmpty
    String email;

    String password;

    @NotEmpty
    @NotNull
    @Pattern(regexp = Constants.ALGERIAN_NUMBER_REGEXP, message = "Le numéro de téléphone doit être au format algérien (+213XXXXXXXXX)")
    String phoneNumber;

    AddressRequestDto address;

    @Enumerated(EnumType.STRING)
    UserStatus status;


    String cin;
    @Past(message = "Date of birth must be in the past")

    Date dateOfBirth;


    @URL(message = "not valid image url")
    String image;

}


