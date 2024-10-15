package com.name.carregistry.repository.impl;

import com.name.carregistry.controller.dtos.Vehicle;
import com.name.carregistry.repository.VehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    List<Vehicle> vehiclesList = new ArrayList<>();


    public Vehicle getVehicleById(Integer id) {
        return vehiclesList.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().get();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {

        if(vehiclesList.stream().anyMatch(v -> v.getId().equals(vehicle.getId()))) {
            return null;
        } else {
            vehiclesList.add(vehicle);
            return vehicle;
        }
    }

    public boolean deleteVehicleById(Integer id) {
         return vehiclesList.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    public Vehicle updateVehicleById(Vehicle vehicle, Integer id) {
            if(getVehicleById(id) == null){
                return null;
            } else {
                deleteVehicleById(id);
                Vehicle updatedVehicle = saveVehicle(vehicle);
                updatedVehicle.setId(id);
                return updatedVehicle;
            }
    }

}
