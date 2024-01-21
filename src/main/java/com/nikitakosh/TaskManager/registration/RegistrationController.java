package com.nikitakosh.TaskManager.registration;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @GetMapping
    public String registrationPage(Model model, @ModelAttribute("request") RegistrationRequest request) {
        model.addAttribute("request", request);
        return "registration";
    }

    @PostMapping
    public String register(@ModelAttribute("request") RegistrationRequest request) {
        registrationService.register(request);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "confirmation";
    }
}
