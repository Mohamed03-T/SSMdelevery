/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 18:50
 *  * @modified : 01/05/2024, 18:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.Parcel;

import java.util.Date;
import java.util.List;

public interface ParcelService {
    void deleteParcel(Long id);

    Parcel loadParcelById(Long id);

    Parcel saveParcel(Parcel parcel);

    Parcel updateParcel(Parcel parcel);

    Parcel markAsDeleted(Long id);

    List<Parcel> loadAllByCreationDateBetween(Date startDate, Date endDate);
}



