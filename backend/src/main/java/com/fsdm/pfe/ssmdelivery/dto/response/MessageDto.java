/*
 *
 *  * @project : SSMDelivery
 *  * @created : 10/05/2024, 16:37
 *  * @modified : 10/05/2024, 16:37
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class MessageDto implements Serializable {

    private final int code;
    private final String message;
    private Object data;

    public MessageDto(int code, String message) {
        this.code = code;

        this.message = message;
    }

}



