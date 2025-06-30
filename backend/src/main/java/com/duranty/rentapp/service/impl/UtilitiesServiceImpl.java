package com.duranty.rentapp.service.impl;

import java.util.List;

import com.duranty.rentapp.model.Utilities;
import com.duranty.rentapp.repository.UtilitiesRepository;
import com.duranty.rentapp.service.contract.UtilitiesService;

public class UtilitiesServiceImpl implements UtilitiesService {

    private final UtilitiesRepository utilitiesRepository;

    public UtilitiesServiceImpl(UtilitiesRepository utilitiesRepository) {
        this.utilitiesRepository = utilitiesRepository;
    }

    @Override
    public List<Utilities> getAllUtilities() {
        return utilitiesRepository.findAll();
    }

    @Override
    public Utilities getUtilitiesById(Long id) {
        return utilitiesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Utilities> getByBrand(String brand) {
        return utilitiesRepository.findByBrand(brand);
    }

    @Override
    public Utilities createUtilities(Utilities utilities) {
        return utilitiesRepository.save(utilities);
    }

    @Override
    public void deleteUtilities(Long id) {
        utilitiesRepository.deleteById(id);
    }
}
