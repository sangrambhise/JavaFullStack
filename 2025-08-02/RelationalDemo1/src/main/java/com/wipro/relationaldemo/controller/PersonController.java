package com.wipro.relationaldemo.controller;
import com.wipro.relationaldemo.entity.Person;
import com.wipro.relationaldemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.getPersonById(id).orElse(null);
    }
}
