package com.andreanbuhchev.bulgarian_racing_community.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @GetMapping()
    public String vehicles(){
        return "vehicles";
    }

    //TODO SEE ALL VEHICLES
    //TODO ADD VEHICLE USER,ADMIN
    //TODO DELETE VEHICLE USER CAN DELETE HIS ,ADMIN CAN DELETE ALL

}
