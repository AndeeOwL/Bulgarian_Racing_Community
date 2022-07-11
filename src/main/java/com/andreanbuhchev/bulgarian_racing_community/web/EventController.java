package com.andreanbuhchev.bulgarian_racing_community.web;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.ArticleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.dto.EventDto;
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


@Controller
@RequestMapping("/events")
public class EventController {


    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping()
    public String events(){
        return "events";
    }

    @GetMapping("/{id}/buy")
    public void buyEvents(@PathVariable Long id,@AuthenticationPrincipal UserDetails userDetails){
        eventService.buyEvent(id,userDetails);
    }

    @GetMapping("/add")
    public String addArticle(Model model) {
        if (!model.containsAttribute("addArticleModel")) {
            model.addAttribute("addArticleModel", new ArticleDto());
        }

        return "add-article";
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
            return "redirect:/add-event";
        }

        eventService.addEvent(addEventModel, userDetails);

        return "redirect:/events";
    }

    @PostMapping("/{id}/delete")
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
    }

}
