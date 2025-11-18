/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 17/11/2025, 00:00
 *  * @modified : 17/11/2025, 00:00
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.config;

import com.fsdm.pfe.ssmdelivery.entity.Admin;
import com.fsdm.pfe.ssmdelivery.model.enums.UserStatus;
import com.fsdm.pfe.ssmdelivery.repository.AdminRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Creates a default admin user on startup when no admin exists.
 * Default credentials (dev/test only): 
 * Email: admin@localhost
 * Password: admin123
 */
@Slf4j
@Component
@Profile("!prod")
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;

    public AdminInitializer(AdminRepo adminRepo, PasswordEncoder passwordEncoder) {
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = adminRepo.count();
        if (count == 0) {
            Admin admin = new Admin();
            admin.setFirstName("Super");
            admin.setLastName("Admin");
            admin.setEmail("admin@localhost");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setPhoneNumber("+212600000000");
            admin.setRole("ADMIN");
            admin.setStatus(UserStatus.ACTIVE);
            adminRepo.save(admin);
            log.info("===================================================");
            log.info("Created default admin user:");
            log.info("Email: admin@localhost");
            log.info("Password: admin123");
            log.info("===================================================");
        }
    }
}
