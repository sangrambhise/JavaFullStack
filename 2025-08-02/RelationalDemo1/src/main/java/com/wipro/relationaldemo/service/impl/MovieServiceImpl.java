package com.wipro.relationaldemo.service.impl;

import com.wipro.relationaldemo.entity.Movie;
import com.wipro.relationaldemo.service.MovieService;
import com.wipro.relationaldemo.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        return movieRepo.findById(id);
    }
}
