package com.Sarthak.WatchlistApplication.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class RatingService {
	
	String apiUrl = "https://www.omdbapi.com/?apikey=308b6d48&t=";
	
	public String getMovieRating(String title) {
		// TODO Auto-generated method stub
		try {
			//try to fetch the rating by calling omdb api
			
			RestTemplate template = new RestTemplate();
			//apiUrl + title
			
			ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title , ObjectNode.class);
			
			ObjectNode jasonObject = response.getBody();
			
			System.out.println(jasonObject.path("imdbRating").asText());
			
			return jasonObject.path("imdbRating").asText();
		} catch (Exception e) {
			//try user entered rating will be taken
			System.out.println("Either movie name is not available or api is down " + e.getMessage());
			
			return null;
			
		}

	}

}
