package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.ChemicalService;
import ua.app.weightings.service.CompanyService;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
@RestController
public class CompanyController {
    private final CompanyService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("companies", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
