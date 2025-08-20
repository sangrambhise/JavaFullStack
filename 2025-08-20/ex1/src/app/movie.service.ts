import { Injectable } from '@angular/core';
import { Movie } from './movie';
@Injectable({
  providedIn: 'root'
})
export class MovieService {
  // Ex5
  private movies: Movie[] = [];

  getMovies(): Movie[] {
    return this.movies;
  }

  addMovie(movie: Movie): void {
    this.movies.push(movie);
  }

  updateMovie(movie: Movie): void {
    const index = this.movies.findIndex(m => m.movieId === movie.movieId);
    if (index !== -1) {
      this.movies[index] = movie;
    }
  }

  deleteMovie(movieId: number): void {
    this.movies = this.movies.filter(m => m.movieId !== movieId);
  }

  getMovieById(id: number): Movie | undefined {
    return this.movies.find(m => m.movieId === id);
  }
}
