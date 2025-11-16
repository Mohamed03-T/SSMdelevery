/*
 *
 *  * @project : SSMDelivery
 *  * @created : 11/05/2024, 13:09
 *  * @modified : 11/05/2024, 13:09
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "code", nullable = false)
    @NotNull
    String code;

    String name;
    String countryCode;
    String postalCode;
    Date createdAt;
    Date updatedAt;

    @OneToMany(mappedBy = "provinceCode", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<City> cities;

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}



