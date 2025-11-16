/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 04/05/2024, 18:49
 *  * @modified : 04/05/2024, 18:49
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller.test;

import com.fsdm.pfe.ssmdelivery.service.Impl.AgencyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class agencyTest {

    private final AgencyServiceImpl agencyService;

    public agencyTest(AgencyServiceImpl agencyService) {
        this.agencyService = agencyService;
    }


}



