package com.wipro.HibernateMovieApp.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name="movie_name")
    private String movieName;
    
    @Column(name="movie_language")
    private String movieLanguage;
    
    @Column(name="imdb_rating")
    private double imdbRating;
	public Movie1() {
		super();
	}
	public Movie1(String movieName, String movieLanguage, double imdbRating) {
		super();	
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.imdbRating = imdbRating;
	}
	
	
	public Movie1(int id, String movieName, String movieLanguage, double imdbRating) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.imdbRating = imdbRating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", movieLanguage=" + movieLanguage + ", imdbRating="
				+ imdbRating + "]";
	}
	
}
