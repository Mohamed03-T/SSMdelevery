
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 04/05/2024, 20:27
 *  * @modified : 04/05/2024, 20:27
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.controller.admin;

import com.fsdm.pfe.ssmdelivery.util.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping({"/admin/", "/admin"})
    public String admin(Model model) {
        model.addAttribute(Constants.CURRENT_PAGE, "/admin");
        return "admin/index";
    }

}



