package com.booking.movieBookingSystem.dto;

import com.booking.movieBookingSystem.model.enums.LanguageEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
@AllArgsConstructor
@Data
@Builder
public class MovieDto {
    private String externalId;

    private String name;

    private String tagLine;

    private LanguageEnum language;

    private boolean hasSubtitles;

    private List<LanguageEnum> subtitlesAvailable;
}
