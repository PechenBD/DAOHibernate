package ru.netology.daohibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Persons;
import ru.netology.daohibernate.service.Service;

import java.util.List;

@AllArgsConstructor
@RestController
public class Controller {
    private final Service service;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersons(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }
}