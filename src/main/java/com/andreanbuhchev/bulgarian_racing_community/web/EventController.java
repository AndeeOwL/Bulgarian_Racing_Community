package com.andreanbuhchev.bulgarian_racing_community.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/events")
public class EventController {



    @GetMapping()
    public String events(){
        return "events";
    }

}
