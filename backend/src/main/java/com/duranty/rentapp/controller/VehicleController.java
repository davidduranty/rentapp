package com.duranty.rentapp.controller;

import com.duranty.rentapp.model.Vehicle;
import com.duranty.rentapp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")

public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/search")
    public List<Vehicle> searchByBrand(@RequestParam String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @PostMapping("/add")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepository.deleteById(id);
    }

}
