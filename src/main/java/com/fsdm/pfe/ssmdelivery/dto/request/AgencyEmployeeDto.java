

/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 29/04/2024, 19:58
 *  * @modified : 29/04/2024, 19:57
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

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

import com.fsdm.pfe.ssmdelivery.entity.AgencyEmployee;
import com.fsdm.pfe.ssmdelivery.model.enums.AgencyEmployeeRole;
import com.fsdm.pfe.ssmdelivery.model.enums.UserStatus;
import com.fsdm.pfe.ssmdelivery.util.Constants;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link AgencyEmployee}
 */
@Value
public class AgencyEmployeeDto implements Serializable {
    Long id;

    @NotNull
    @NotBlank
    String name;

    @NotNull
    @Email
    String email;

    @NotNull
    @Pattern(regexp = Constants.MOROCCAN_NUMBER_REGEXP)
    String phoneNumber;

    @Enumerated(EnumType.STRING)
    UserStatus status;
    String cin;
    Date dateOfBirth;
    String image;
    String employeeNumber;
    double salary;
    Integer managerLevel;
    AgencyEmployeeRole agencyEmployeeRole;
}


