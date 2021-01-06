package com.booking.movieBookingSystem.service;

import com.booking.movieBookingSystem.dto.TheatreDto;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
public interface TheatreService {
    List<TheatreDto> getActiveTheatresInACityForAMovie(long cityId, long movieId);
}
