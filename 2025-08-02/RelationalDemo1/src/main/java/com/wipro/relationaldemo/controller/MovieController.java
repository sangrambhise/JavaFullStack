package com.wipro.relationaldemo.controller;
import com.wipro.relationaldemo.entity.Movie;
import com.wipro.relationaldemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovieById(id).orElse(null);
    }
}
