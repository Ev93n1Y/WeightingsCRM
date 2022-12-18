package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.ChemicalService;
import ua.app.weightings.service.EventService;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
@RestController
public class EventController {
    private final EventService service;

    @GetMapping
    public ModelAndView get() {
        ModelAndView result = new ModelAndView("index");
        try {
            result.addObject("events", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
