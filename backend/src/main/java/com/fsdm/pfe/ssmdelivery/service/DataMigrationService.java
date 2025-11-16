/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 20:50
 *  * @modified : 04/06/2024, 20:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.model.datamigration.ImportObjectType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DataMigrationService {
    void migrateData(MultipartFile file, ImportObjectType objectType) throws IOException;

}



