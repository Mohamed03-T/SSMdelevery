/*
 * **
 *  * @project : DeliX
 *  * @created : 12/11/2025, 02:00
 *  * @modified : 12/11/2025, 02:00
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.dto.request;

import com.fsdm.pfe.delix.util.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransporterRequestDto {

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères")
    private String firstName;

    @NotBlank(message = "Le nom de famille est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom de famille doit contenir entre 2 et 50 caractères")
    private String lastName;

    @NotBlank(message = "L'adresse e-mail est obligatoire")
    @Email(message = "L'adresse e-mail n'est pas valide")
    private String email;

    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    @Pattern(regexp = Constants.ALGERIAN_NUMBER_REGEXP, message = "Numéro de téléphone invalide. Format algérien requis: +213XXXXXXXXX ou 0XXXXXXXXX")
    private String phoneNumber;

    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String password;

    private String cin;

    @Past(message = "La date de naissance doit être dans le passé")
    private Date dateOfBirth;

    @NotBlank(message = "Le numéro de permis de conduire est obligatoire")
    private String licenseNumber;

    @NotBlank(message = "La plaque d'immatriculation est obligatoire")
    private String vehicleMatricule;

    @NotBlank(message = "Le type de véhicule est obligatoire")
    private String vehicleType;

    @NotBlank(message = "Le numéro d'enregistrement est obligatoire")
    private String registrationNumber;
}
