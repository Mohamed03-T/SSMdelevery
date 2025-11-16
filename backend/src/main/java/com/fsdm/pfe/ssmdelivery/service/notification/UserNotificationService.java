/*
 *
 *  * @project : SSMDelivery
 *  * @created : 16/05/2024, 18:24
 *  * @modified : 16/05/2024, 18:24
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.notification;

import com.fsdm.pfe.ssmdelivery.entity.User;

public interface UserNotificationService {
    void sendNotificationToUser(String title, String message, User user);

    void sendNotificationToAll(String title, String message);
}



