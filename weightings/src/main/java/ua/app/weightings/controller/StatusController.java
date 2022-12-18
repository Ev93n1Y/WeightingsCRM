package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.DriverService;
import ua.app.weightings.service.StatusService;

@Controller
@RequestMapping("/status")
@RequiredArgsConstructor
@RestController
public class StatusController {
    private final StatusService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("statuses", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
