package com.booking.movieBookingSystem.controller;

import com.booking.movieBookingSystem.dto.MovieDto;
import com.booking.movieBookingSystem.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
@RestController
@RequestMapping(value = "/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping(value = "/get/allActiveInACity/{city_id}")
    public ResponseEntity<?> getAllActiveMoviesOfACity(@PathVariable("city_id") long cityId) {
            return new ResponseEntity<>(movieService.getActiveMoviesInACity(cityId), HttpStatus.OK);
    }

    @GetMapping(value = "/get/allInACity/{city_id}")
    public ResponseEntity<?> getAllMoviesOfACity(@PathVariable("city_id") long cityId) {
        return new ResponseEntity<>(movieService.getMoviesInACity(cityId), HttpStatus.OK);
    }


}
