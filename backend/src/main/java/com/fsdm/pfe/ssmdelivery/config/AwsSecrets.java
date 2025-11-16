/*
 *
 *  * @project : SSMDelivery
 *  * @created : 24/05/2024, 13:50
 *  * @modified : 24/05/2024, 13:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AwsSecrets {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class AwsSecretsDatabase {
        private String username;
        private String password;
        private String host;
        private String engine;
        private String port;
        private String dbInstanceIdentifier;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class AwsSecretsSmtp {
        private String username;
        private String password;
    }

}



