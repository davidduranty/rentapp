package com.duranty.rentapp.repository;

import com.duranty.rentapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // Tu pourras ajouter des méthodes personnalisées ici plus tard

    List<Vehicle> findByBrand(String brand);
}