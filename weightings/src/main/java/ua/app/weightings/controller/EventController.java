package ua.app.weightings.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.app.weightings.model.dto.EventDto;
import ua.app.weightings.model.dto.UserDto;
import ua.app.weightings.service.ChemicalService;
import ua.app.weightings.service.EventService;
import ua.app.weightings.service.UserService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
@RestController
public class EventController {
    private final EventService service;
    private final UserService userService;

    @GetMapping
    public ModelAndView getEvents() {
        ModelAndView indexModel = new ModelAndView("index");
        try {
            indexModel.addObject("events", service.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexModel;
    }

    @GetMapping("/create")
    public ModelAndView newEventForm(@CurrentSecurityContext(expression="authentication")
                                               Authentication authentication){
        ModelAndView indexModel = new ModelAndView("index");
        /*System.err.println("getPrincipal: " + authentication.getPrincipal());
        System.err.println("getCredentials: " + authentication.getCredentials());
        System.err.println("isAuthenticated: " + authentication.isAuthenticated());
        System.err.println("getDetails: " + authentication.getDetails());
        System.err.println("getAuthorities: " + authentication.getAuthorities());
        System.err.println("getName: " + authentication.getName());
        System.err.println("authentication: " + authentication);*/
        try {
            UserDto authUser = userService.findByName(authentication.getName());
            indexModel.addObject("authUser", authUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexModel;
    }

    @PostMapping("/create")
    public ModelAndView createNewEvent(@ModelAttribute("producer") EventDto eventDto){
        //TODO create table with ability to pick up saved parameters or create new one if needed
        ModelAndView indexModel = new ModelAndView("index");
        try {
            List<EventDto> eventDtoList = service.findAll();
            indexModel.addObject("events", eventDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexModel;
    }

}
