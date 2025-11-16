/*
 *
 *  * @project : SSMDelivery
 *  * @created : 04/06/2024, 19:36
 *  * @modified : 04/06/2024, 19:36
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.datamegration;

public interface DataProcessor<T> {
    T processRowData(String[] row);
}



