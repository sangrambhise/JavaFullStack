package com.wipro.relationaldemo.repo;
import com.wipro.relationaldemo.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
