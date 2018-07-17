package com.stackroute.movieapp.eventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;

@Component
public class EventListener implements ApplicationListener<ContextRefreshedEvent> {
	private MovieRepository movieRepo;
	
	   @Autowired 
	   public EventListener(MovieRepository movieRepo) {
		super();
		this.movieRepo = movieRepo;
	}


	@Override 
	   public void onApplicationEvent(ContextRefreshedEvent event) {
	       movieRepo.save(new Movie(2,"wdbjb","abdjbsf","66666","ajdbfaj"));
	   }
}
