package com.wipro.relationaldemo.repo;


import com.wipro.relationaldemo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Integer> {
}
