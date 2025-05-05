package com.Sarthak.WatchlistApplication.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sarthak.WatchlistApplication.entity.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
