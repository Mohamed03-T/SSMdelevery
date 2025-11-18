/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 17/11/2025, 00:00
 *  * @modified : 17/11/2025, 00:00
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller;

import com.fsdm.pfe.ssmdelivery.dto.request.TransporterRequestDto;
import com.fsdm.pfe.ssmdelivery.dto.response.ResponseDataDto;
import com.fsdm.pfe.ssmdelivery.entity.Transporter;
import com.fsdm.pfe.ssmdelivery.model.enums.Role;
import com.fsdm.pfe.ssmdelivery.model.enums.UserStatus;
import com.fsdm.pfe.ssmdelivery.model.enums.VehicleType;
import com.fsdm.pfe.ssmdelivery.repository.TransporterRepo;
import com.fsdm.pfe.ssmdelivery.service.Impl.TransporterServiceImpl;
import com.fsdm.pfe.ssmdelivery.service.Impl.UserServiceImpl;
import com.fsdm.pfe.ssmdelivery.util.Constants;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CustomerTransporterController {

    private final TransporterRepo transporterRepo;
    private final TransporterServiceImpl transporterService;
    private final UserServiceImpl userService;

    public CustomerTransporterController(TransporterRepo transporterRepo, TransporterServiceImpl transporterService, UserServiceImpl userService) {
        this.transporterRepo = transporterRepo;
        this.transporterService = transporterService;
        this.userService = userService;
    }

    @GetMapping("/become-transporter")
    public String becomeTransporterPage(Model model, CsrfToken csrfToken) {
        model.addAttribute(Constants.CURRENT_PAGE, "/become-transporter");
        model.addAttribute("pageTitle", "Devenir transporteur - SSMDelivery");
        model.addAttribute("csrf_token", csrfToken.getToken());
        model.addAttribute("vehicleTypes", VehicleType.values());
        return "home/becomeTransporter";
    }

    @PostMapping("/become-transporter")
    public ResponseEntity<ResponseDataDto> submitTransporterRequest(@Valid @ModelAttribute TransporterRequestDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDataDto.builder().success(false).message("Données invalides. Veuillez vérifier le formulaire.").build());
        }

        try {
            // Check if email already exists
            if (userService.loadUserByUsername(dto.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDataDto.builder().success(false).message("L'adresse e-mail est déjà utilisée").build());
            }

            // Check if phone number already exists
            if (transporterRepo.findAll().stream().anyMatch(t -> t.getPhoneNumber().equals(dto.getPhoneNumber()))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDataDto.builder().success(false).message("Le numéro de téléphone est déjà utilisé").build());
            }

            // Check if CIN already exists
            if (dto.getCin() != null && !dto.getCin().isEmpty()) {
                if (transporterService.loadByCin(dto.getCin()).isPresent()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(ResponseDataDto.builder().success(false).message("Le numéro CIN est déjà utilisé").build());
                }
            }

            // Create new transporter with INACTIVE status (pending admin approval)
            Transporter transporter = new Transporter();
            transporter.setFirstName(dto.getFirstName());
            transporter.setLastName(dto.getLastName());
            transporter.setEmail(dto.getEmail());
            transporter.setPhoneNumber(dto.getPhoneNumber());
            transporter.setPassword(userService.encodePassword(dto.getPassword()));
            transporter.setCin(dto.getCin());
            transporter.setDateOfBirth(dto.getDateOfBirth());
            transporter.setRole(Role.TRANSPORTER.name());
            
            // Mark as INACTIVE until admin approves
            transporter.setStatus(UserStatus.INACTIVE);

            // Vehicle operator fields
            transporter.setLicenseNumber(dto.getLicenseNumber());
            transporter.setVihiculeMtricule(dto.getVehicleMatricule());
            if (dto.getVehicleType() != null && !dto.getVehicleType().isEmpty()) {
                transporter.setVehicleType(VehicleType.valueOf(dto.getVehicleType()));
            }
            
            // Transporter specific field
            transporter.setRegistrationNumber(dto.getRegistrationNumber());

            // Save transporter
            transporterRepo.save(transporter);

            log.info("New transporter request submitted: {}", transporter.getEmail());
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .success(true)
                    .message("Votre demande a été envoyée avec succès. L'administrateur examinera votre demande.")
                    .build());

        } catch (Exception e) {
            log.error("Error submitting transporter request: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDataDto.builder()
                            .success(false)
                            .message("Erreur serveur lors de la soumission: " + e.getMessage())
                            .build());
        }
    }
}
