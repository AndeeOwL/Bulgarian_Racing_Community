package com.andreanbuhchev.bulgarian_racing_community.model.repository;

import com.andreanbuhchev.bulgarian_racing_community.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    List<Vehicle> findAll();
}
