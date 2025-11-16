/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 23/04/2024, 18:13
 *  * @modified : 23/04/2024, 18:13
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *  **
 */

package com.fsdm.pfe.ssmdelivery.entity;

import com.fsdm.pfe.ssmdelivery.converters.ParcelLocationConverter;
import com.fsdm.pfe.ssmdelivery.model.ParcelLocation;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class ParcelHistory {

    @Id
    private Long id;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ParcelTracking;

    @Convert(converter = ParcelLocationConverter.class)
    private ParcelLocation currentLocation;

    @PrePersist
    protected void onCreated() {
        this.ParcelTracking = new Date();

    }


}



