package com.wipro.relationaldemo.repo;

import com.wipro.relationaldemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}
