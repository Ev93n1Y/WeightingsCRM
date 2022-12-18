package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ua.app.weightings.service.UserService;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class IndexController {
    private final UserService service;

    @GetMapping
    public ModelAndView get() {
        return new ModelAndView("index");
    }
}
