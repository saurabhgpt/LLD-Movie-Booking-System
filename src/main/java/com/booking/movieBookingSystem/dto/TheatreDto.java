package com.booking.movieBookingSystem.dto;

import com.booking.movieBookingSystem.model.entities.Address;
import com.booking.movieBookingSystem.model.entities.Screen;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

/**
 * created by saurabhgupta on 06/01/21
 */
public class TheatreDto {
    private String externalId;

    private String name;

    private Address address;

    private List<Screen> screenList;
}
