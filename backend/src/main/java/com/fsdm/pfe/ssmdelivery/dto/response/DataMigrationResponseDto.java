/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 17:37
 *  * @modified : 04/06/2024, 17:37
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Builder
@Data
public class DataMigrationResponseDto implements Serializable {
    File logsFile;
    private String message;
    private String status;
}




