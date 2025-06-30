package com.duranty.rentapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duranty.rentapp.model.Utilities;
import com.duranty.rentapp.repository.UtilitiesRepository;

@RestController
@RequestMapping("/utilities")
public class UtilitiesController {

    final UtilitiesRepository utilitiesRepository;

    public UtilitiesController(UtilitiesRepository utilitiesRepository) {
        this.utilitiesRepository = utilitiesRepository;
    }

    @GetMapping
    public ResponseEntity<List<Utilities>> getAllUtilities() {
        return new ResponseEntity<>(utilitiesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Utilities>> searchByBrand(@RequestParam String brand) {
        return new ResponseEntity<>(utilitiesRepository.findByBrand(brand), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilities> getUtilitiesById(@PathVariable Long id) {
        Optional<Utilities> utilities = utilitiesRepository.findById(id);
        if (utilities.isPresent()) {
            return new ResponseEntity<>(utilities.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Utilities> createUtilities(@RequestBody Utilities utilities) {
        return new ResponseEntity<>(utilitiesRepository.save(utilities), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Utilities> updateUtilities(@PathVariable Long id, @RequestBody Utilities input) {
        Optional<Utilities> optionUtility = utilitiesRepository.findById(id);
        if (optionUtility.isPresent()) {
            Utilities existingUtilities = optionUtility.get();
            existingUtilities.setBrand(input.getBrand());
            existingUtilities.setModel(input.getModel());
            existingUtilities.setWeight(input.getWeight());
            existingUtilities.setVolume(input.getVolume());
            existingUtilities.setImage(input.getImage());
            existingUtilities.setElectric(input.isElectric());
            existingUtilities.setLocation(input.getLocation());
            return new ResponseEntity<>(utilitiesRepository.save(existingUtilities), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUtilities(@PathVariable Long id) {
        Optional<Utilities> utility = utilitiesRepository.findById(id);
        if (utility.isPresent()) {
            utilitiesRepository.delete(utility.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
