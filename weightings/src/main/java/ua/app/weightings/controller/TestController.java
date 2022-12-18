package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ua.app.weightings.service.StatusService;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class TestController {
    private final StatusService service;

    @GetMapping
    public ModelAndView get() {
        return new ModelAndView("test");
    }
}
