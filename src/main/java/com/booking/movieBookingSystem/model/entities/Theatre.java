package com.booking.movieBookingSystem.model.entities;

import com.booking.movieBookingSystem.model.enums.LanguageEnum;
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
@Table(name = "theatre")
public class Theatre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_active", nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean isActive;

    @JoinColumn(name = "address_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "theatre")
    @JsonBackReference
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "theatre")
    @JsonBackReference
    @JoinColumn(name = "screen_ids_list", nullable = false)
    private List<Screen> screenList;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
