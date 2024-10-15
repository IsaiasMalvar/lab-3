package com.name.carregistry.controller;
import com.name.carregistry.controller.dtos.VehicleRequest;
import com.name.carregistry.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleInfoById(@PathVariable Integer id) {

        log.info("Retrieving vehicle");
        try{
            return ResponseEntity.ok(vehicleService.getVehicleById(id));
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable Integer id) {

        log.info("Deleting vehicle");
        try{
            vehicleService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addCar(@RequestBody VehicleRequest vehicleRequest) {
        try{
            vehicleService.saveCar(vehicleRequest);
            return ResponseEntity.ok().build();
        } catch ( Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<?> updateCarById(@PathVariable Integer id,@RequestBody VehicleRequest vehicleRequest) {
            try {
                vehicleService.updateById(id, vehicleRequest);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
    }
}
