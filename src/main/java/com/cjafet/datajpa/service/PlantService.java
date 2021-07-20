package com.cjafet.datajpa.service;

import com.cjafet.datajpa.data.Plant;
import com.cjafet.datajpa.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Plant getPlantByName(String name) {
        return new Plant();
    }

    //Save a new Plant and return its Id
    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();
    }

    //Check if a plant has been delivered
    public Boolean delivered(Long id) {
        // return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
        return plantRepository.deliveryCompleted(id);

    }

    //Find a list of plants cheaper than a specified amount
    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
