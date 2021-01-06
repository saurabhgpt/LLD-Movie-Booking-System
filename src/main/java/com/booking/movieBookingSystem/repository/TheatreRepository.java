package com.booking.movieBookingSystem.repository;

import com.booking.movieBookingSystem.dto.TheatreDto;
import com.booking.movieBookingSystem.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
@Repository
public interface TheatreRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor {

//    @Query("select new com.booking.movieBookingSystem.dto.TheatreDto(t.externalId, " +
//            "t.name, t.address, t.screenList) FROM Theatre t INNER JOIN Address a ON ")
    List<TheatreDto> allTheatresRunningAMovieInACity(long movieId, long cityId);
}
