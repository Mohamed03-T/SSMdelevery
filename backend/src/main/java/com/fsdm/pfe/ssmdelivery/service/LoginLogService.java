/*
 *
 *  * @project : SSMDelivery
 *  * @created : 13/05/2024, 12:15
 *  * @modified : 13/05/2024, 12:15
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.User;

public interface LoginLogService {
    void saveLoginLog(User user, String userAgent, String ipAddress, boolean loginStatus, String loginMethod);
}



