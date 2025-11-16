/*
 *
 *  * @project : SSMDelivery
 *  * @created : 06/05/2024, 17:14
 *  * @modified : 06/05/2024, 17:14
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import lombok.Value;

import java.io.Serializable;

@Value
public class AlertMessageDto implements Serializable {
    public String type;
    public String message;


    public enum AlertType {
        SUCCESS,
        INFO,
        WARNING,
        ERROR
    }
}



