package com.stackroute.movieapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String title;
	private String imdbId;
	private String year;
	private String poster;
	public int getMovieId() {
		return movieId;
	}
	
	public Movie() {
		
	}
	
	public Movie(String title, String imdbId, String year, String poster) {
		super();
		this.title = title;
		this.imdbId = imdbId;
		this.year = year;
		this.poster = poster;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}	
	
}
