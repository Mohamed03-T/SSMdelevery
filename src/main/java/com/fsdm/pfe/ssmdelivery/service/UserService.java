/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 18:44
 *  * @modified : 01/05/2024, 18:44
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.User;

public interface UserService {
    void deleteUser(Long id);

    User loadUserById(Long id);

    User saveUser(User user);

    void updateUser(User user);

    boolean existsUserByEmail(String email);


}



