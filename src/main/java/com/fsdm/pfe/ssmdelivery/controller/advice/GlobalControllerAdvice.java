
/*
 *
 *  * @project : SSMDelivery
 *  * @created : 08/05/2024, 20:02
 *  * @modified : 08/05/2024, 20:02
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.ssmdelivery.controller.advice;

import com.fsdm.pfe.ssmdelivery.dto.response.MyUserResponseDto;
import com.fsdm.pfe.ssmdelivery.entity.User;
import com.fsdm.pfe.ssmdelivery.service.Impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;


@ControllerAdvice
public class GlobalControllerAdvice {
    private final UserServiceImpl userService;

    public GlobalControllerAdvice(UserServiceImpl userService) {
        this.userService = userService;
    }


    @ModelAttribute
    public void addUserDetails(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            User userDetails = userService.loadUserByUsername(((UserDetails) auth.getPrincipal()).getUsername());
            model.addAttribute("userDetails", new MyUserResponseDto(userDetails));
        }
    }
}


