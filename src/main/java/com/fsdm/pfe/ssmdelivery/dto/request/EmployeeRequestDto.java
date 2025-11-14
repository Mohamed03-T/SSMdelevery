
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 29/04/2024, 20:20
 *  * @modified : 29/04/2024, 20:20
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */


package com.fsdm.pfe.ssmdelivery.dto.request;

import com.fsdm.pfe.ssmdelivery.entity.Employee;
import com.fsdm.pfe.ssmdelivery.model.enums.UserStatus;
import com.fsdm.pfe.ssmdelivery.util.Constants;
import jakarta.validation.constraints.*;
import lombok.Value;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Employee}
 */

@Value
public class EmployeeRequestDto implements Serializable {
    Long id;
    @NotNull(message = "tye name should be not empty")
    @Size
    @NotEmpty
    String name;

    @NotNull
    @Email
    @NotEmpty
    String email;

    String role;

    @Pattern(regexp = Constants.MOROCCAN_NUMBER_REGEXP)
    String phoneNumber;

    AddressRequestDto address;
    UserStatus status;
    String cin;

    @Past
    Date dateOfBirth;

    double balance;

    @URL
    String image;

    String employeeNumber;
}


