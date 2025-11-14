/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 19:15
 *  * @modified : 01/05/2024, 19:15
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

import com.fsdm.pfe.ssmdelivery.entity.Employee;

public interface EmployeeService {
    void deleteEmployee(Long id);

    Employee loadEmployeeById(Long id);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee updateEmployeeEmail(Long employeeId, String newEmail);
}



