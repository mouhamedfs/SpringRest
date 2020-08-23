package com.demo.demo.Api;

import com.demo.demo.Models.Personne;
import com.demo.demo.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/personne")
@RestController
public class PersonneController {
    @Autowired
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @PostMapping
    public void addPersonne(@Validated @NonNull @RequestBody Personne personne) {
        personneService.addPersonne(personne);
    }

    @GetMapping
    public List<Personne> getAllPeople() {
        return personneService.getListPersonne();
    }

    @GetMapping(path ="/{id}")
    public Personne getById(@PathVariable("id") UUID id){
        return personneService.selectPerById(id).
                orElse(null);
    }
    @DeleteMapping(path ="/{id}")
    public void deletePersonneById(@PathVariable("id") UUID id){
         personneService.deletePersonneByid(id);
    }
    @PutMapping(path ="/{id}")
    public void updatePersonneById(@PathVariable("id") UUID id,@Validated @NonNull @RequestBody Personne personnetoUpdate){
        personneService.updatePersonneByid(id, personnetoUpdate);
    }
}
