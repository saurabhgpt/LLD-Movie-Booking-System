package com.booking.movieBookingSystem.service.impl;

import com.booking.movieBookingSystem.dto.TheatreDto;
import com.booking.movieBookingSystem.repository.TheatreRepository;
import com.booking.movieBookingSystem.service.TheatreService;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
public class TheatreServiceImpl implements TheatreService {
    final private TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public List<TheatreDto> getActiveTheatresInACityForAMovie(long cityId, long movieId) {
//        return theatreRepository.;
        return null;
    }
}
