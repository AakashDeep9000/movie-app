package com.stackroute.movieapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exception.MovieAlreadyExistsException;
import com.stackroute.movieapp.exception.MovieNotFoundException;
import com.stackroute.movieapp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie addMovie(Movie movie) throws MovieAlreadyExistsException{
		if(!movieRepository.existsById(movie.getMovieId()))
		return movieRepository.save(movie);
		else
		throw new MovieAlreadyExistsException("Movie already exists");
	}

	@Override
	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public boolean deleteMovie(int id) throws MovieNotFoundException{
		if(movieRepository.existsById(id))
		{
		movieRepository.deleteById(id);
		return true;
		}
		else
		throw new MovieNotFoundException("Movie not found");
			
	}

	@Override
	public Movie updateMovie(Movie movie, int id) throws MovieNotFoundException{
			if(movieRepository.existsById(id)) {
			movie.setMovieId(id);
			return movieRepository.save(movie);
			}
			else
			throw new MovieNotFoundException("Not Found");	
	}

	@Override
	public Optional<Movie> getMovieById(int id) throws MovieNotFoundException {
		if(movieRepository.existsById(id))
		{
		return movieRepository.findById(id);
		}
		else 
		throw new MovieNotFoundException("Movie not found");
	}

	@Override
	public List<Movie> getMovieByTitle(String title){
	return movieRepository.getMovieByTitle(title);
	}

}
