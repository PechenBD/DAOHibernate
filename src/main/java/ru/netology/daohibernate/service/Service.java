package ru.netology.daohibernate.service;

import lombok.AllArgsConstructor;
import ru.netology.daohibernate.entity.Persons;
import ru.netology.daohibernate.repository.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    final Repository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Persons> getPersonsByAgeLessThanOrderByAge(int age) {
        return repository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}