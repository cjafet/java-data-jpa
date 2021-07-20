package com.cjafet.datajpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class QueryDemo {

    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_PERSON_BY_COMPOSER =
            "select p from Person p " +
                    "where p.favoriteComposer like :favoriteComposer";

//    public Person findPersonByFavoriteComposer(String favoriteComposer){
//        TypedQuery<Person> query = entityManager.createQuery(FIND_PERSON_BY_COMPOSER, Person.class);
//        query.setParameter("favoriteComposer", favoriteComposer);
//        return query.getSingleResult();
//    }
}
