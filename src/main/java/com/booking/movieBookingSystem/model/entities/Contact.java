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
 * created by saurabhgupta on 03/01/21
 */
@Entity
@Builder
@ToString
@Table(name = "contact")
public class Contact implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "is_mobile_verified", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isMobileVerified;

    @Column(name = "is_email_verified", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isEmailVerified;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition = "" +
            "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @Generated(GenerationTime.ALWAYS)
    private Date updatedAt;
}
