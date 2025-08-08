package com.wipro.relationaldemo.service;
import com.wipro.relationaldemo.entity.Movie;

import java.util.Optional;

public interface MovieService {
    Movie saveMovie(Movie movie);
    Optional<Movie> getMovieById(int id);
}
