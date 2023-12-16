package ru.netology.daohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daohibernate.entity.Persons;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Persons, Integer> {
    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByAgeLessThanOrderByAge(int age);

    Optional<Persons> findByNameAndSurname(String name, String surname);
}
