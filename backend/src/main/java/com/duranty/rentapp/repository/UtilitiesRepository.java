package com.duranty.rentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duranty.rentapp.model.Utilities;

@Repository
public interface UtilitiesRepository extends JpaRepository<Utilities, Long> {

    List<Utilities> findByBrand(String brand);
}
