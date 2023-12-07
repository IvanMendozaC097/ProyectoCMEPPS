package com.CMEPPS.proyectotareas.ui_driver_adapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String showWelcomePage(ModelMap model) {
        return "welcome";
    }
}

