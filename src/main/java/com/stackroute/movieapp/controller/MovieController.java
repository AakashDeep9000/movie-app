package com.stackroute.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.service.MovieService;

@RequestMapping("/api/v1")
@RestController
public class MovieController {
	
	private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping("/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) 
	{
		return new ResponseEntity<Movie>(movieService.addMovie(movie),HttpStatus.CREATED);
	}
	
	@GetMapping("/movies")
	public ResponseEntity<?> getMovies()
	{
		return new ResponseEntity<Iterable<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable("id") int id)
	{
		movieService.deleteMovie(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
}
