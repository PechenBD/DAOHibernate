package ru.netology.daohibernate.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.entity.Persons;
import ru.netology.daohibernate.service.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class Controller {
    private final Service service;

    @Secured({"ROLE_READ"})
    @GetMapping("/by-city")
    public List<Persons> getPersons(@RequestParam String city) {
        return service.getPersonsByCity(city);
    }

    @RolesAllowed({"ROLE_WRITE"})
    @GetMapping("/age-less-than")
    public List<Persons> getPersonsByAgeLessThanOrderByAge(@RequestParam int age) {
        return service.getPersonsByAgeLessThanOrderByAge(age);
    }

    @PreAuthorize("hasAnyRole('ROLE_WRITE', 'ROLE_DELETE')")
    @GetMapping("/by-name-and-surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return service.getPersonsByNameAndSurname(name, surname);
    }

    @GetMapping("/hello")
    @PostAuthorize("#username == authentication.principal.username")
    public String getHello(String username) {
        return "Hello, " + username;
    }
}