/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 27/04/2024, 13:09
 *  * @modified : 26/04/2024, 18:26
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 26/04/2024, 18:25
 *  * @modified : 26/04/2024, 18:11
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 25/04/2024, 17:09
 *  * @modified : 25/04/2024, 17:08
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */


package com.fsdm.pfe.ssmdelivery.validation.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserValidate {
    String message() default "Invalid User";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


