package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.VehicleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.VehicleView;
import com.andreanbuhchev.bulgarian_racing_community.service.VehicleService;
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
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping()
    public String vehicles(Model model){

        List<VehicleView> vehicles = vehicleService.findAll();

        model.addAttribute("allVehicles", vehicles);
        return "vehicles";
    }

    @GetMapping("/add")
    public String addVehicle(Model model) {
        if (!model.containsAttribute("addVehicleModel")) {
            model.addAttribute("addVehicleModel", new VehicleDto());
        }

        return "add-vehicle";
    }

    @PostMapping("/add")
    public String addVehicle(@Valid VehicleDto addVehicleModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addVehicleModel", addVehicleModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addVehicleModel",
                    bindingResult);
            return "redirect:/vehicles/add";
        }

        vehicleService.addVehicle(addVehicleModel, userDetails);

        return "redirect:/vehicles";
    }

    @PostMapping("/{id}/delete")
    public void deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
    }

        //TODO EDIT DELETE METHOD TO WORK CORRECTLY


}
