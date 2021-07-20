package com.cjafet.datajpa.service;

import com.cjafet.datajpa.data.Delivery;
import com.cjafet.datajpa.data.RecipientAndPrice;
import com.cjafet.datajpa.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
