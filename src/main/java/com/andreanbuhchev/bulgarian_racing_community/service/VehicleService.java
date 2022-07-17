package com.andreanbuhchev.bulgarian_racing_community.service;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.VehicleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Vehicle;
import com.andreanbuhchev.bulgarian_racing_community.model.view.FastestVehiclesView;
import com.andreanbuhchev.bulgarian_racing_community.model.view.VehicleView;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDto addVehicleModel, UserDetails userDetails);

    void deleteVehicle(Long id);
    List<FastestVehiclesView> getFastest();

    List<VehicleView> findAll();
}
