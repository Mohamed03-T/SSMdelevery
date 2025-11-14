/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 19:37
 *  * @modified : 04/06/2024, 19:37
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.datamegration;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DataMigration {
    void migrateData(MultipartFile file) throws IOException;
}



