/*
 *
 *  * @project : SSMDelivery
 *  * @created : 10/05/2024, 18:46
 *  * @modified : 10/05/2024, 18:46
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.User;
import com.fsdm.pfe.ssmdelivery.entity.VerificationToken;

public interface VerificationTokenService {

    VerificationToken createVerification(User user);

    boolean verifyEmail(String token);
}



