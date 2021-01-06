package com.booking.movieBookingSystem.service;

import com.booking.movieBookingSystem.dto.MovieDto;
import com.booking.movieBookingSystem.dto.TheatreDto;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
public interface MovieService {
    List<MovieDto> getActiveMoviesInACity(long cityId);

    List<MovieDto> getMoviesInACity(long cityId);
}
