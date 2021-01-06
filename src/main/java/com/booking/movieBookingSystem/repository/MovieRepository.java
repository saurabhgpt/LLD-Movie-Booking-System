package com.booking.movieBookingSystem.repository;

import com.booking.movieBookingSystem.dto.MovieDto;
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
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor {

    @Query("select new com.booking.movieBookingSystem.dto.MovieDto(m.externalId, " +
            "m.name, m.tagLine, m.language, m.language, m.hasSubtitles, m.subtitlesAvailable" +
            ") from Movie m INNER JOIN MovieCityMapping mcm ON m.id = mcm.movie where mcm.city = ?1 " +
            "and m.isActive = ?2")
    List<MovieDto> getActiveRunsheetsInACity(long cityId, boolean isActive);

    @Query("select new com.booking.movieBookingSystem.dto.MovieDto(m.externalId, " +
            "m.name, m.tagLine, m.language, m.language, m.hasSubtitles, m.subtitlesAvailable" +
            ") from Movie m INNER JOIN MovieCityMapping mcm ON m.id = mcm.movie where mcm.city = ?1")
    List<MovieDto> getRunsheetsInACity(long cityId);
}
