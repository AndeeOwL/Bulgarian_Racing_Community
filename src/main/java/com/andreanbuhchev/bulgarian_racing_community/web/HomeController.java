package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.Vehicle;
import com.andreanbuhchev.bulgarian_racing_community.model.view.FastestVehiclesView;
import com.andreanbuhchev.bulgarian_racing_community.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {

    private final VehicleService vehicleService;

    public HomeController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public String home(Model model){

     List<FastestVehiclesView> fastest = vehicleService.getFastest();

     model.addAttribute("First",fastest.get(0));
     model.addAttribute("Second",fastest.get(1));
     model.addAttribute("Third",fastest.get(2));


        return "home";
    }


}
