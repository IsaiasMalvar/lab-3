package com.name.carregistry.service;

import com.name.carregistry.controller.dtos.VehicleRequest;
import com.name.carregistry.controller.dtos.VehicleResponse;

public interface VehicleService {

    VehicleResponse getVehicleById(Integer id) throws Exception;

    void deleteById(Integer id) throws Exception;

    VehicleResponse updateById(Integer id, VehicleRequest vehicleRequest) throws Exception;

    VehicleResponse saveCar(VehicleRequest vehicleRequest) throws Exception;
}
