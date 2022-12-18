package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.DriverService;
import ua.app.weightings.service.RoleService;
import ua.app.weightings.service.UserService;

@Controller
@RequestMapping("/driver")
@RequiredArgsConstructor
@RestController
public class DriverController {
    private final DriverService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("drivers", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
