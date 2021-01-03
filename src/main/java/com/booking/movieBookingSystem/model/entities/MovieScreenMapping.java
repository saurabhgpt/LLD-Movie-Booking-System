package com.booking.movieBookingSystem.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * created by saurabhgupta on 02/01/21
 */
@Entity
@Builder
@ToString
@Table(name = "movie_screen_mapping")
public class MovieScreenMapping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @JoinColumn(name = "movie_id", nullable = false)
    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Movie movie;

    @JoinColumn(name = "screen_id", nullable = false)
    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Screen screen;

    @Column(name = "start_timing", nullable = false)
    @Temporal(TemporalType.TIME)
    private String startTiming;

    @Column(name = "end_timing", nullable = false)
    @Temporal(TemporalType.TIME)
    private String endTiming;

    @Column(name = "is_active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
