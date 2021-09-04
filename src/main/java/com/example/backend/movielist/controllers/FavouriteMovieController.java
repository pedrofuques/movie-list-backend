package com.example.backend.movielist.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.example.backend.movielist.model.FavouriteMovie;
import com.example.backend.movielist.repository.FavouriteMovieRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favourite-movies")
public class FavouriteMovieController {

    private final FavouriteMovieRepository favouriteMovieRepository;

    public FavouriteMovieController(FavouriteMovieRepository favouriteMovieRepository) {
        this.favouriteMovieRepository = favouriteMovieRepository;
    }

    @GetMapping("/{userId}")
    public List<FavouriteMovie> getFavouriteMovies(@PathVariable String userId) {
        return favouriteMovieRepository.findAllByUserId(userId);
    }

    @GetMapping()
    public List<FavouriteMovie> getAll() {
        return favouriteMovieRepository.findAll();
    }

    @PostMapping
    public ResponseEntity createFavouriteMovie(@RequestBody FavouriteMovie favouriteMovie) throws URISyntaxException {
        FavouriteMovie savedFavouriteMovie = favouriteMovieRepository.save(favouriteMovie);
        return ResponseEntity.created(new URI("/favourite-movies/" + savedFavouriteMovie.getId()))
                .body(savedFavouriteMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFavouriteMovie(@PathVariable Long id) {
        favouriteMovieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
