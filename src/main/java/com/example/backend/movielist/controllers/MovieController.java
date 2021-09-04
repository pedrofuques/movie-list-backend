package com.example.backend.movielist.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.example.backend.movielist.model.FavouriteMovie;
import com.example.backend.movielist.model.Movie;
import com.example.backend.movielist.model.Search;
import com.example.backend.movielist.model.SearchRoot;
import com.example.backend.movielist.repository.FavouriteMovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    private final FavouriteMovieRepository favouriteMovieRepository;

    public MovieController(FavouriteMovieRepository favouriteMovieRepository) {
        this.favouriteMovieRepository = favouriteMovieRepository;
    }

    @GetMapping("search-movie/{search}/{userId}")
    public SearchRoot getAllMovies(@PathVariable String search, @PathVariable String userId) {

        // Search in OMDB Api
        SearchRoot searchRoot = restTemplate
                .getForObject("http://www.omdbapi.com/?s=" + search + "&type=movie&apikey=4842a784", SearchRoot.class);

        // Movie searched not Found
        if (searchRoot.getResponse().equals("False"))
            return searchRoot;

        if (searchRoot.getSearch() != null && searchRoot.getSearch().size() > 0) {
            // Get All Favourite Movies
            List<FavouriteMovie> favouriteMovieList = favouriteMovieRepository.findAllByUserId(userId);

            // Set All Movies to Favourite False and return SearchRoot
            if (favouriteMovieList.size() == 0) {
                for (Search movie : searchRoot.getSearch()) {
                    movie.setFavouriteMovie(false);
                    movie.setIdToRemove(0L);
                }
                return searchRoot;
            }

            // Check if the movie is favourite and store the Id
            for (Search movie : searchRoot.getSearch()) {
                FavouriteMovie favMovie = favouriteMovieRepository.findByMovieIdAndUserId(movie.getImdbID(), userId);
                if (favMovie == null) {
                    movie.setFavouriteMovie(false);
                    movie.setIdToRemove(0L);
                } else {
                    movie.setFavouriteMovie(true);
                    movie.setIdToRemove(favMovie.getId());
                }
            }
        }

        return searchRoot;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        Movie movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + id + "&plot=full&apikey=4842a784",
                Movie.class);
        return movie;
    }

    @PostMapping
    public ResponseEntity createFavouriteMovie(@RequestBody FavouriteMovie favouriteMovie) throws URISyntaxException {
        FavouriteMovie savedFavouriteMovie = favouriteMovieRepository.save(favouriteMovie);
        return ResponseEntity.created(new URI("/favourite-movies/" + savedFavouriteMovie.getId()))
                .body(savedFavouriteMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFavouriteMovie(@PathVariable Long id, @RequestBody FavouriteMovie favouriteMovie) {
        FavouriteMovie currentFavouriteMovie = favouriteMovieRepository.findById(id).orElseThrow(RuntimeException::new);
        currentFavouriteMovie.setMovieId(favouriteMovie.getMovieId());
        currentFavouriteMovie = favouriteMovieRepository.save(favouriteMovie);

        return ResponseEntity.ok(currentFavouriteMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFavouriteMovie(@PathVariable Long id) {
        favouriteMovieRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
