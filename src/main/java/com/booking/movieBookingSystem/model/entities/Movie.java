package com.booking.movieBookingSystem.model.entities;

import com.booking.movieBookingSystem.model.enums.LanguageEnum;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * created by saurabhgupta on 02/01/21
 */
@Entity
@Builder
@ToString
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tag_line")
    private String tagLine;

    @Column(name = "is_active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isActive;

    @Column(name = "language",  nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @Column(name = "has_subtitles", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean hasSubtitles;

    @Column(name = "subtitles_available")
    @Enumerated(EnumType.STRING)
    private List<LanguageEnum> subtitlesAvailable;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
