package com.duranty.rentapp.controller;

import com.duranty.rentapp.model.Vehicle;
import com.duranty.rentapp.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicles")

public class VehicleController {

    final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return new ResponseEntity<>(vehicleRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> searchByBrand(@RequestParam String brand) {
        return new ResponseEntity<>(vehicleRepository.findByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicule = vehicleRepository.findById(id);
        if (vehicule.isPresent()) {
            return new ResponseEntity<>(vehicule.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(vehicleRepository.save(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicule = vehicleRepository.findById(id);

        if (vehicule.isPresent()) {
            Vehicle existingVehicle = vehicule.get();
            existingVehicle.setBrand(vehicle.getBrand());
            existingVehicle.setModel(vehicle.getModel());
            existingVehicle.setYear(vehicle.getYear());
            existingVehicle.setDailyPrice(vehicle.getDailyPrice());
            return new ResponseEntity<>(vehicleRepository.save(existingVehicle), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        Optional<Vehicle> vehicule = vehicleRepository.findById(id);
        if (vehicule.isPresent()) {
            vehicleRepository.delete(vehicule.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
