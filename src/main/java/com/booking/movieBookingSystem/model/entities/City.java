package com.booking.movieBookingSystem.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_operational", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isOperational;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
    @JsonBackReference
    @JoinColumn(name = "theatre_ids_list", nullable = false)
    private List<Theatre> theatreList;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
