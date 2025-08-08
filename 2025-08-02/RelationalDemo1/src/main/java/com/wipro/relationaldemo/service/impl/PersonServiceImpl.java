package com.wipro.relationaldemo.service.impl;

import com.wipro.relationaldemo.entity.Person;
import com.wipro.relationaldemo.repo.PersonRepo;
import com.wipro.relationaldemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person savePerson(Person person) {
        person.getPosts().forEach(post -> post.setPerson(person));
        return personRepo.save(person);
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        return personRepo.findById(id);
    }
}
