package com.booking.movieBookingSystem.controller;

import com.booking.movieBookingSystem.service.MovieService;
import com.booking.movieBookingSystem.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by saurabhgupta on 06/01/21
 */
@RestController
@RequestMapping(value = "/v1/theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;
    @GetMapping(value = "/get/allActiveInACityRunningAMovie/{city_id}/{movie_id}")
    public ResponseEntity<?> getAllActiveTheatresRunningAMoviesInACity(@PathVariable("city_id") long cityId,
                                                                       @PathVariable("movie_id") long movieId) {
        return new ResponseEntity<>(theatreService.getActiveTheatresInACityForAMovie(cityId, movieId), HttpStatus.OK);
    }

    @GetMapping(value = "/get/allInACity/{city_id}")
    public ResponseEntity<?> getAllMoviesOfACity(@PathVariable("city_id") long cityId) {
        return new ResponseEntity<>(movieService.getMoviesInACity(cityId), HttpStatus.OK);
    }
}
