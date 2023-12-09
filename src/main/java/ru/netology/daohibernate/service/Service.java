package ru.netology.daohibernate.service;

import lombok.AllArgsConstructor;
import ru.netology.daohibernate.entity.Persons;
import ru.netology.daohibernate.repository.Repository;

import java.util.List;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    final Repository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}