package com.booking.movieBookingSystem.service.impl;

import com.booking.movieBookingSystem.dto.MovieDto;
import com.booking.movieBookingSystem.repository.MovieRepository;
import com.booking.movieBookingSystem.service.MovieService;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
public class MovieServiceImpl implements MovieService {
    final private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDto> getActiveMoviesInACity(long cityId) {
        return movieRepository.getActiveRunsheetsInACity(cityId, true);
    }

    @Override
    public List<MovieDto> getMoviesInACity(long cityId) {
        return movieRepository.getRunsheetsInACity(cityId);
    }
}
