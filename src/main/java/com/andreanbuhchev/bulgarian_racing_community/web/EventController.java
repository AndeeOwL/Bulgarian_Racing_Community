package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.EventDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.EventView;
import com.andreanbuhchev.bulgarian_racing_community.service.EventService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/events")
public class EventController {


    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public String events(Model model){


        List<EventView> events = eventService.findAll();

        model.addAttribute("allEvents", events);

        return "events";
    }

    @GetMapping("/buy/{id}")
    public String buyEvents(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails){

        eventService.buyEvent(id,userDetails);

        return "redirect:/events";

    }

    @GetMapping("/add")
    public String addArticle(Model model) {
        if (!model.containsAttribute("addEventModel")) {
            model.addAttribute("addEventModel", new EventDto());
        }

        return "add-event";
    }

    @PostMapping("/add")
    public String addEvent(@Valid EventDto addEventModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addEventModel", addEventModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addEventModel",
                    bindingResult);
            return "redirect:/events/add";
        }

        eventService.addEvent(addEventModel, userDetails);

        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){

        eventService.deleteEvent(id);

        return "redirect:/events";
    }

}
