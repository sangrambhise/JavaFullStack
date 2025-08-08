package com.wipro.relationaldemo.service;
import com.wipro.relationaldemo.entity.Person;
import java.util.Optional;

public interface PersonService {
    Person savePerson(Person person);
    Optional<Person> getPersonById(int id);
}
