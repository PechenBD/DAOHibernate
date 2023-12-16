package ru.netology.daohibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Persons;
import ru.netology.daohibernate.service.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class Controller {
    private final Service service;

    @GetMapping("/by-city")
    public List<Persons> getPersons(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/age-less-than")
    public List<Persons> getPersonsByAgeLessThanOrderByAge(@RequestParam int age) {
        return service.getPersonsByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }
}