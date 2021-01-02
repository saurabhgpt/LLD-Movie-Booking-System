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
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "external_id")
    private String externalId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @Column(name = "is_active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date createdAt;
}
