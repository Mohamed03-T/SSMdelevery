/*
 *
 *  * @project : SSMDelivery
 *  * @created : 18/05/2024, 19:44
 *  * @modified : 18/05/2024, 19:44
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.PasswordResetToken;
import com.fsdm.pfe.ssmdelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface PasswordResetTokenRepo extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);

    void deleteAllByExpiryDateBefore(Date now);

    boolean existsByToken(String token);

    void deleteByToken(String token);

    boolean existsByUser(User user);

    void deleteAllByUser(User user);

    PasswordResetToken findByUser(User user);

    PasswordResetToken findByUser_Id(Long id);


}


