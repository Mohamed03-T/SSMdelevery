/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 19:24
 *  * @modified : 01/05/2024, 19:24
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.Admin;

public interface AdminService {
    void deleteAdmin(Long id);

    Admin loadAdminById(Long id);

    Admin saveAdmin(Admin admin);

    Admin updateAdmin(Admin admin);
}



