package com.stackroute.movieapp.service;

import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;

@Service
public interface MovieService {

	public Movie addMovie(Movie movie);
	public Iterable<Movie> getAllMovies();
	public void deleteMovie(int id);
	public Movie updateMovie(Movie movie,int id);
}
