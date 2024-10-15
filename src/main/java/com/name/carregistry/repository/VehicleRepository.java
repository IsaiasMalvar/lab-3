package com.name.carregistry.repository;


import com.name.carregistry.controller.dtos.Vehicle;

import java.util.Optional;

public interface VehicleRepository {

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    boolean deleteVehicleById(Integer id);

    Vehicle updateVehicleById(Vehicle vehicle, Integer id);
}
