/*
 *
 *  * @project : SSMDelivery
 *  * @created : 18/05/2024, 20:55
 *  * @modified : 18/05/2024, 20:55
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.PasswordResetToken;
import com.fsdm.pfe.ssmdelivery.entity.User;

import java.util.Date;
import java.util.Optional;

public interface PasswordResetTokenService {

    void createPasswordResetTokenForUser(User user, String token);

    void deletePasswordResetToken(String token);

    void deleteAllExpiredSince(Date now);

    Optional<PasswordResetToken> findByToken(String token);

}



