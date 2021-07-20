package com.cjafet.datajpa.repository;

import com.cjafet.datajpa.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    //public Boolean findPlantByDeliveryCompleted(Long plantId);

    //public List<Plant> findPlantLessThanPrice(BigDecimal price);

    //check if a plant by this id exists where delivery has been completed
    Boolean existsPlantByIdAndDeliveryCompleted(Long id, Boolean delivered);

    //to return a wrapper class, you may need to construct it as a projection
    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.id = :plantId")
    public Boolean deliveryCompletedBoolean(Long plantId);

    //you can return a primitive directly
    @Query("select p.delivery.completed from Plant p where p.id = :plantId")
    public Boolean deliveryCompleted(Long plantId);

    public List<Plant> findByPriceLessThan(BigDecimal price);

}
