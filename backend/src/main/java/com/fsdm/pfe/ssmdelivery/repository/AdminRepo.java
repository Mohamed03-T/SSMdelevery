/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 25/04/2024, 14:46
 *  * @modified : 25/04/2024, 14:46
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.repository;

import com.fsdm.pfe.ssmdelivery.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}



