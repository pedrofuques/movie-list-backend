package com.example.backend.movielist.repository;

import java.util.List;

import com.example.backend.movielist.model.FavouriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FavouriteMovieRepository extends JpaRepository<FavouriteMovie, Long> {

    @Query("SELECT f FROM FavouriteMovie f WHERE f.userId = ?1")
    List<FavouriteMovie> findAllByUserId(String userId);

    @Query("SELECT f FROM FavouriteMovie f WHERE f.movieId = ?1 and f.userId = ?2")
    FavouriteMovie findByMovieIdAndUserId(String movieId, String userId);
}
