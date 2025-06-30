package com.duranty.rentapp.service.contract;

import java.util.List;

import com.duranty.rentapp.model.Utilities;

public interface UtilitiesService {
    List<Utilities> getAllUtilities();

    Utilities getUtilitiesById(Long id);

    List<Utilities> getByBrand(String brand);

    Utilities createUtilities(Utilities utilities);

    void deleteUtilities(Long id);

}
