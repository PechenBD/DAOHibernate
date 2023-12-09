package ru.netology.daohibernate.repository;

import lombok.AllArgsConstructor;
import ru.netology.daohibernate.entity.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Persons> getPersonsByCity(String city) {
        return entityManager.createQuery("select person from Persons person WHERE person.cityOfLiving = :city",
                        Persons.class)
                .setParameter("city", city)
                .getResultList();
    }
}
