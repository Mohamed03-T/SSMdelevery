/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 01/05/2024, 18:38
 *  * @modified : 01/05/2024, 18:38
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service;

/**
 * Service interface for {@link com.fsdm.pfe.ssmdelivery.service.Impl.EmailServiceImpl}
 */
public interface EmailService {
    /**
     * this function should use for sending a simple email message
     *
     * @param toEmail : email address for the target user
     * @param subject : the email subject
     * @param text    : the email body
     * @see org.apache.naming.factory.SendMailFactory
     */

    void sendMessage(String toEmail, String subject, String text);

    void sendEmailWithAttachment(String toEmail, String subject, String text, String pathToAttachment);

}



