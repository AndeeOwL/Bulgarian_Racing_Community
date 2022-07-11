package com.andreanbuhchev.bulgarian_racing_community.service.impl;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.VehicleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.UserEntity;
import com.andreanbuhchev.bulgarian_racing_community.model.entity.Vehicle;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;
import com.andreanbuhchev.bulgarian_racing_community.model.repository.VehicleRepository;
import com.andreanbuhchev.bulgarian_racing_community.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addVehicle(VehicleDto addVehicleModel, UserDetails userDetails) {
        Vehicle newVehicle = new Vehicle();

        UserEntity user = userRepository.findByUsername(userDetails.getUsername()).
                orElseThrow();

        modelMapper.map(addVehicleModel,newVehicle);
        newVehicle.setUserEntity(user);



        vehicleRepository.save(newVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
   public List<Vehicle> getFastest() {
        return vehicleRepository.findAll().stream().limit(3).collect(Collectors.toList());
    }

}
