/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 12/11/2025, 02:00
 *  * @modified : 12/11/2025, 02:00
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller.admin;

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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class TransporterController {

    private final TransporterRepo transporterRepo;
    private final TransporterServiceImpl transporterService;
    private final UserServiceImpl userService;

    public TransporterController(TransporterRepo transporterRepo, TransporterServiceImpl transporterService, UserServiceImpl userService) {
        this.transporterRepo = transporterRepo;
        this.transporterService = transporterService;
        this.userService = userService;
    }

    @GetMapping("/admin/transporters/add")
    public String addTransporterPage(Model model, CsrfToken csrfToken) {
        model.addAttribute(Constants.CURRENT_PAGE, "/admin/transporters");
        model.addAttribute("csrf_token", csrfToken.getToken());
        model.addAttribute("vehicleTypes", VehicleType.values());
        return "admin/transporter/add";
    }

    @PostMapping("/admin/transporters/add")
    public ResponseEntity<ResponseDataDto> addTransporter(@Valid TransporterRequestDto transporterRequestDto, BindingResult bindingResult) {
        
        // Validation errors
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            List<FieldError> errorList = new ArrayList<>(errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDataDto.builder()
                            .success(false)
                            .message("Erreur dans les données saisies")
                            .error(errorList)
                            .build());
        }

        try {
            // Check if email already exists
            if (userService.loadUserByUsername(transporterRequestDto.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDataDto.builder()
                                .success(false)
                                .message("L'adresse e-mail est déjà utilisée")
                                .build());
            }

            // Check if phone number already exists (using repository directly)
            if (transporterRepo.findAll().stream()
                    .anyMatch(t -> t.getPhoneNumber().equals(transporterRequestDto.getPhoneNumber()))) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDataDto.builder()
                                .success(false)
                                .message("Le numéro de téléphone est déjà utilisé")
                                .build());
            }

            // Check if CIN already exists
            if (transporterRequestDto.getCin() != null && !transporterRequestDto.getCin().isEmpty()) {
                if (transporterService.loadByCin(transporterRequestDto.getCin()).isPresent()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(ResponseDataDto.builder()
                                    .success(false)
                                    .message("Le numéro CIN est déjà utilisé")
                                    .build());
                }
            }

            // Create new transporter
            Transporter transporter = new Transporter();
            transporter.setFirstName(transporterRequestDto.getFirstName());
            transporter.setLastName(transporterRequestDto.getLastName());
            transporter.setEmail(transporterRequestDto.getEmail());
            transporter.setPhoneNumber(transporterRequestDto.getPhoneNumber());
            transporter.setPassword(userService.encodePassword(transporterRequestDto.getPassword()));
            transporter.setCin(transporterRequestDto.getCin());
            transporter.setDateOfBirth(transporterRequestDto.getDateOfBirth());
            transporter.setRole(Role.TRANSPORTER.name());
            transporter.setStatus(UserStatus.ACTIVE);
            
            // VehicleOperatorEmployee fields
            transporter.setLicenseNumber(transporterRequestDto.getLicenseNumber());
            transporter.setVihiculeMtricule(transporterRequestDto.getVehicleMatricule());
            transporter.setVehicleType(VehicleType.valueOf(transporterRequestDto.getVehicleType()));
            
            // Transporter specific field
            transporter.setRegistrationNumber(transporterRequestDto.getRegistrationNumber());

            // Generate employee number
            String employeeNumber = "TR" + System.currentTimeMillis();
            transporter.setEmployeeNumber(employeeNumber);

            // Save transporter
            transporterRepo.save(transporter);

            log.info("Transporter created successfully: {}", transporter.getEmail());
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .success(true)
                    .message("Transporteur ajouté avec succès")
                    .build());

        } catch (Exception e) {
            log.error("Error creating transporter: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDataDto.builder()
                            .success(false)
                            .message("Erreur lors de l'ajout du transporteur: " + e.getMessage())
                            .build());
        }
    }

    @GetMapping("/admin/transporters")
    public String listTransporters(Model model) {
        model.addAttribute(Constants.CURRENT_PAGE, "/admin/transporters");
        model.addAttribute("transporters", transporterRepo.findAll());
        return "admin/transporter/listTransporters";
    }

    @PostMapping("/admin/transporters/delete/{id}")
    public ResponseEntity<ResponseDataDto> deleteTransporter(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
        try {
            Transporter transporter = transporterRepo.findById(id).orElse(null);
            if (transporter == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ResponseDataDto.builder()
                                .success(false)
                                .message("Transporteur introuvable")
                                .build());
            }

            transporterRepo.delete(transporter);
            log.info("Transporter deleted successfully: {}", id);
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .success(true)
                    .message("Transporteur supprimé avec succès")
                    .build());

        } catch (Exception e) {
            log.error("Error deleting transporter: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDataDto.builder()
                            .success(false)
                            .message("Erreur lors de la suppression du transporteur: " + e.getMessage())
                            .build());
        }
    }

    @PostMapping("/admin/transporters/approve/{id}")
    public ResponseEntity<ResponseDataDto> approveTransporter(@org.springframework.web.bind.annotation.PathVariable("id") Long id) {
        try {
            Transporter transporter = transporterRepo.findById(id).orElse(null);
            if (transporter == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ResponseDataDto.builder()
                                .success(false)
                                .message("Transporteur introuvable")
                                .build());
            }

            // Approve transporter by setting status to ACTIVE
            transporter.setStatus(UserStatus.ACTIVE);
            
            // Generate employee number if not exists
            if (transporter.getEmployeeNumber() == null || transporter.getEmployeeNumber().isEmpty()) {
                transporter.setEmployeeNumber("TR" + System.currentTimeMillis());
            }
            
            transporterRepo.save(transporter);

            log.info("Transporter approved successfully: {}", transporter.getEmail());
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .success(true)
                    .message("Transporteur approuvé avec succès")
                    .build());

        } catch (Exception e) {
            log.error("Error approving transporter: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ResponseDataDto.builder()
                            .success(false)
                            .message("Erreur lors de l'approbation: " + e.getMessage())
                            .build());
        }
    }
}




