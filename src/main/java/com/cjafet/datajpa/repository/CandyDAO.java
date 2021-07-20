package com.cjafet.datajpa.repository;

import com.cjafet.datajpa.data.CandyData;

import java.util.List;

public interface CandyDAO {
    List<CandyData> list();
    void addToDelivery(Long candyId, Long deliveryId);
    List<CandyData> findByDelivery(Long deliveryId);
}
