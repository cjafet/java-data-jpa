package com.cjafet.datajpa.repository;

import com.cjafet.datajpa.data.Delivery;
import com.cjafet.datajpa.data.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public List<Delivery> findDeliveriesByName(String name){
        TypedQuery<Delivery> deliveries = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        deliveries.setParameter("name", name);
        return deliveries.getResultList();
    }

    // query a list of Plants with deliveryId matching the one provided and sum their prices.
    public RecipientAndPrice getBill(Long deliveryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> criteria = cb.createQuery(RecipientAndPrice.class);
        Root<RecipientAndPrice> root = criteria.from(RecipientAndPrice.class);

        criteria.select(cb.construct(
                RecipientAndPrice.class,
                root.get("delivery").get("name"),
                cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));

        return entityManager.createQuery(criteria).getSingleResult();

    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }
}
