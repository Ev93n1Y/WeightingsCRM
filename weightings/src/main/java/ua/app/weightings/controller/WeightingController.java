package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.StatusService;
import ua.app.weightings.service.WeightingService;

@Controller
@RequestMapping("/weighting")
@RequiredArgsConstructor
@RestController
public class WeightingController {
    private final WeightingService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("weightings", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
