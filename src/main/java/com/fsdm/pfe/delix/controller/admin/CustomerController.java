/*
 * **
 *  * @project : DeliX
 *  * @created : 11/11/2024, 00:00
 *  * @modified : 11/11/2024, 00:00
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.controller.admin;

import com.fsdm.pfe.delix.dto.request.CustomerRequestDto;
import com.fsdm.pfe.delix.dto.response.AlertMessageDto;
import com.fsdm.pfe.delix.dto.response.ResponseDataDto;
import com.fsdm.pfe.delix.entity.Customer;
import com.fsdm.pfe.delix.entity.Province;
import com.fsdm.pfe.delix.service.CustomerService;
import com.fsdm.pfe.delix.service.Impl.location.ProvinceServiceImpl;
import com.fsdm.pfe.delix.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {
    private final ProvinceServiceImpl provinceService;
    private final CustomerService customerService;
    private final Validator validator;
    private final PasswordEncoder passwordEncoder;

    public CustomerController(ProvinceServiceImpl provinceService, CustomerService customerService, 
                             Validator validator, PasswordEncoder passwordEncoder) {
        this.provinceService = provinceService;
        this.customerService = customerService;
        this.validator = validator;
        this.passwordEncoder = passwordEncoder;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/admin/customer/add")
    public String addCustomer(Model model, CsrfToken csrfToken) {
        List<Province> provinces = provinceService.loadAll();
        model.addAttribute("provinces", ProvinceServiceImpl.convertListToDto(provinces));
        model.addAttribute("csrf_token", csrfToken.getToken());
        return "admin/customer/add";
    }

    @PostMapping("/admin/customer/add")
    public ResponseEntity<ResponseDataDto> addCustomer(CustomerRequestDto customerRequestDto) {
        DataBinder binder = new DataBinder(customerRequestDto);
        binder.setValidator(validator);
        binder.validate();
        BindingResult result = binder.getBindingResult();

        if (result.hasErrors()) {
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .data(null)
                    .success(false)
                    .error(result.getAllErrors())
                    .message("Veuillez vérifier les champs")
                    .build());
        }

        try {
            // Create new customer
            Customer customer = new Customer();
            customer.setFirstName(customerRequestDto.getFirstName());
            customer.setLastName(customerRequestDto.getLastName());
            customer.setEmail(customerRequestDto.getEmail());
            customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
            
            // Auto-generate password: firstName + currentYear (e.g., mohamed2025)
            String generatedPassword;
            if (customerRequestDto.getPassword() != null && !customerRequestDto.getPassword().isEmpty()) {
                generatedPassword = customerRequestDto.getPassword();
            } else {
                // Generate password from firstName + current year
                String cleanFirstName = customerRequestDto.getFirstName()
                    .toLowerCase()
                    .replaceAll("[^a-z]", ""); // Remove special characters and accents
                int currentYear = java.time.Year.now().getValue();
                generatedPassword = cleanFirstName + currentYear;
            }
            customer.setPassword(passwordEncoder.encode(generatedPassword));
            
            // Set date of birth
            if (customerRequestDto.getDateOfBirth() != null) {
                customer.setDateOfBirth(customerRequestDto.getDateOfBirth());
            }
            
            // Set CIN
            if (customerRequestDto.getCin() != null && !customerRequestDto.getCin().isEmpty()) {
                customer.setCin(customerRequestDto.getCin());
            }
            
            // Set image URL if provided
            if (customerRequestDto.getImage() != null && !customerRequestDto.getImage().isEmpty()) {
                customer.setImage(customerRequestDto.getImage());
            }
            
            // Set status
            if (customerRequestDto.getStatus() != null) {
                customer.setStatus(customerRequestDto.getStatus());
            }
            
            customerService.saveCustomer(customer);
            
        } catch (Exception e) {
            log.error("Erreur lors de l'enregistrement du client : {}", e.getMessage());
            return ResponseEntity.ok(ResponseDataDto.builder()
                    .data(null)
                    .success(false)
                    .message(e.getMessage())
                    .error(null)
                    .build());
        }
        
        return ResponseEntity.ok(ResponseDataDto.builder()
                .data(null)
                .success(true)
                .message("Client enregistré avec succès")
                .error(null)
                .build());
    }

    @GetMapping("/admin/customers")
    public String getCustomers(Model model) {
        model.addAttribute(Constants.CURRENT_PAGE, "/admin/customers");
        try {
            // Get all customers from the repository
            List<Customer> customers = customerService.loadAllCustomers();
            model.addAttribute("customers", customers);
        } catch (Exception e) {
            log.error("Erreur lors du chargement des clients : {}", e.getMessage());
            model.addAttribute("customers", List.of());
        }
        return "admin/customer/listCustomers";
    }

    @PostMapping("/admin/customer/delete/{id}")
    public ResponseEntity<AlertMessageDto> deleteCustomer(@PathVariable("id") Long id) {
        log.debug("RequestEntity : {}", id);
        try {
            customerService.deleteCustomer(id);
        } catch (Exception e) {
            log.error("Erreur lors de la suppression du client : {}", e.getMessage());
            return ResponseEntity.ok(new AlertMessageDto(
                    AlertMessageDto.AlertType.ERROR.name().toLowerCase(), 
                    e.getMessage()));
        }
        return ResponseEntity.ok(new AlertMessageDto(
                AlertMessageDto.AlertType.SUCCESS.name().toLowerCase(), 
                "Client supprimé avec succès"));
    }
}
