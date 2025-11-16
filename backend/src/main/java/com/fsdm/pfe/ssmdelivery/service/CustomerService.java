/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 19:21
 *  * @modified : 01/05/2024, 19:21
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.dto.request.RegisterRequestDto;
import com.fsdm.pfe.ssmdelivery.dto.request.UpdatePasswordRequestDto;
import com.fsdm.pfe.ssmdelivery.entity.Customer;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void deleteCustomer(Long id);

    Customer loadCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer registerCustomer(RegisterRequestDto registerRequestDto, String baseUrl);

    Optional<Customer> loadByEmail(String email);

    void logoutCustomer(Authentication auth);

    void updatePassword(String email, UpdatePasswordRequestDto updatePasswordRequestDto);

    List<Customer> loadAllCustomers();
}



