/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 19:11
 *  * @modified : 01/05/2024, 19:11
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.PrivilegesGroup;

public interface PrivilegesGroupService {
    void deletePrivilegesGroup(Long id);

    PrivilegesGroup loadPrivilegesGroupById(Long id);

    PrivilegesGroup savePrivilegesGroup(PrivilegesGroup privilegesGroup);

    PrivilegesGroup updatePrivilegesGroup(PrivilegesGroup privilegesGroup);
}



