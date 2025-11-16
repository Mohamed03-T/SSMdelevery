/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 27/04/2024, 14:08
 *  * @modified : 27/04/2024, 14:08
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller.test;

import com.fsdm.pfe.ssmdelivery.entity.Customer;
import com.fsdm.pfe.ssmdelivery.service.AddressService;
import com.fsdm.pfe.ssmdelivery.service.Impl.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustommerTest {
    private final CustomerServiceImpl customerService;
    private final AddressService addressService;

    public CustommerTest(CustomerServiceImpl customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }


    @GetMapping("/test/customer/update")
    public ResponseEntity<Customer> updateCustomer() {
        Customer customer = customerService.loadCustomerById(1L);
        customer.setEmail("abdelhak@tset.com");
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @GetMapping("/test/customer/get")
    public ResponseEntity<Customer> getCustomer() {
        Customer customer = customerService.loadCustomerById(1L);
        return ResponseEntity.ok(customer);

    }
}





