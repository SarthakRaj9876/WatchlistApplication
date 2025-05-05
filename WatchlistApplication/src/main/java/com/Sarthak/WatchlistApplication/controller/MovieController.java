package com.Sarthak.WatchlistApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Sarthak.WatchlistApplication.entity.Movie;
import com.Sarthak.WatchlistApplication.service.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showwatchListForm(@RequestParam(required = false) Integer id) {
		
		String viewName = "watchlistItemForm";
		
		Map<String, Object> model = new HashMap<>();
		
		if(id==null) {
			model.put("watchlistItem", new Movie());
		}
		else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
//		Movie dummyMovie = new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(5);
//		dummyMovie.setPriority("high");
//		dummyMovie.setComment("hello");
//		model.put("watchlistItem", dummyMovie);
		
		
		return new ModelAndView(viewName , model);
		
		
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForn(@Valid @ModelAttribute("watchlistItem") Movie movie ,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			// if error are there redisplay the form and let user enter again\
			
			return new ModelAndView("watchlistItemForm");
		}
		
		
		/*
		 * if(id==null){
		 * create new id
		 * }
		 * else{
		 * update
		 * }
		 */
		Integer id = movie.getId();
		if(id==null) {
			databaseService.create(movie);
		}
		else {
			databaseService.update(movie,id);
		}
		
		
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);

	}
	@GetMapping("/watchlist")
	public ModelAndView getWatchlist() {
		// TODO Auto-generated method stub

		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();
		List<Movie> movieList = databaseService.getAllMovies();
		model.put("watchlistrows", movieList);
		model.put("noofmovies", movieList.size());
		return new ModelAndView(viewName, model);
	
	

}
	
	
}
