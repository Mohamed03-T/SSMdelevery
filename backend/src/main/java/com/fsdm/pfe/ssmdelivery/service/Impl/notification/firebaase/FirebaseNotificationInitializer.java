
/*
 *
 *  * @project : SSMDelivery
 *  * @created : 16/05/2024, 18:50
 *  * @modified : 16/05/2024, 18:50
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.service.Impl.notification.firebaase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class FirebaseNotificationInitializer {

    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    @PostConstruct
    public void initialize() {
        if (firebaseConfigPath == null || firebaseConfigPath.isBlank()) {
            log.warn("Firebase config path is not set, skipping Firebase initialization");
            return;
        }
        ClassPathResource res = new ClassPathResource(firebaseConfigPath);
        if (!res.exists()) {
            log.warn("Firebase config not found at classpath: {} - skipping initialization", firebaseConfigPath);
            return;
        }
        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(res.getInputStream())).build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception ex) {
            log.error("Failed to initialize Firebase - continuing without Firebase: {}", ex.getMessage());
        }
    }
}



