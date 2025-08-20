import { Component } from '@angular/core';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-movie',
  imports: [FormsModule, CommonModule],
  templateUrl: './movie.component.html',
  styleUrl: './movie.component.css'
})
export class MovieComponent {
  // Ex5
 movies: Movie[] = [];
  newMovie: Movie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
  isEditing: boolean = false;

  constructor(private empService: MovieService) {
    this.loadMovies();
  }

  loadMovies() {
    this.movies = this.empService.getMovies();
  }

  addMovie() {
    if (!this.isEditing) {
      this.empService.addMovie({ ...this.newMovie });
    } else {
      this.empService.updateMovie({ ...this.newMovie });
      this.isEditing = false;
    }
    this.newMovie = { movieId: 0, movieName: '', language: '', imdbRating: 0 };
    this.loadMovies();
  }

  editMovie(movie: Movie) {
    this.newMovie = { ...movie };
    this.isEditing = true;
  }

  deleteMovie(id: number) {
    this.empService.deleteMovie(id);
    this.loadMovies();
  }
}
