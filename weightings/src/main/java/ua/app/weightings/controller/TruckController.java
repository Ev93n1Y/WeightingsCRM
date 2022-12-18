package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.app.weightings.model.dto.UserDto;
import ua.app.weightings.service.RoleService;
import ua.app.weightings.service.TruckService;
import ua.app.weightings.service.UserService;
import ua.app.weightings.service.converter.RoleConverter;

import java.util.HashSet;
import java.util.UUID;

@Controller
@RequestMapping("/truck")
@RequiredArgsConstructor
@RestController
public class TruckController {
    private final TruckService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("trucks", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
