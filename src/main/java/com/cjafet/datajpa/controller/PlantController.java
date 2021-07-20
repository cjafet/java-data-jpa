package com.cjafet.datajpa.controller;

import com.cjafet.datajpa.data.Plant;
import com.cjafet.datajpa.data.PlantDTO;
import com.cjafet.datajpa.service.PlantService;
import com.cjafet.datajpa.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name) {
        Plant plant = plantService.getPlantByName(name);
        return convertToPlantDTO(plant);
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name) {
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertToPlantDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{amount}")
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal amount) {
        return plantService.findPlantsBelowPrice(amount);
    }


}
