package com.Sarthak.WatchlistApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sarthak.WatchlistApplication.repositry.MovieRepo;
import com.Sarthak.WatchlistApplication.entity.Movie;

@Service
public class DatabaseService {
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	RatingService ratingService;
	
	public void create(Movie movie) {
		
		String rating = ratingService.getMovieRating(movie.getTitle());
		if(rating != null ) {
			movie.setRating(Float.parseFloat(rating));
		}
		
		movieRepo.save(movie);

	}
	
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findAll();

	}
	public Movie getMovieById(Integer id) {
		// TODO Auto-generated method stub
		return movieRepo.findById(id).get();

	}

	public void update(Movie movie, Integer id) {
		// TODO Auto-generated method stub
		Movie toBeUpdated = getMovieById(id);
		toBeUpdated.setTitle(movie.getTitle());
		toBeUpdated.setRating(movie.getRating());
		toBeUpdated.setPriority(movie.getPriority());
		toBeUpdated.setComment(movie.getComment());
		
		movieRepo.save(toBeUpdated);
		
	}

}
