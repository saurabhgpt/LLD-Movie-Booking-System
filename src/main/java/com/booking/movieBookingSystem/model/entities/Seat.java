package com.booking.movieBookingSystem.model.entities;

import com.booking.movieBookingSystem.model.enums.SeatTier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.ToString;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * created by saurabhgupta on 03/01/21
 */
@Entity
@Builder
@ToString
@Table(name = "seat")
public class Seat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @JoinColumn(name = "screen_id", nullable = false)
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Screen screen;

    @Column(name = "seat_tier")
    @Enumerated(EnumType.STRING)
    private SeatTier seatTier;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
