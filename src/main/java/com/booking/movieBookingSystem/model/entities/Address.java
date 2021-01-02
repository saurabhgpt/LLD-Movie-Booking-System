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
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
    @JsonBackReference
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "created_at", nullable = false)
    @Generated(GenerationTime.ALWAYS)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
