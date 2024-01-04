package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")
public class Location extends BaseEntity{
    @Column(name="location_name", nullable=false, length=100)
    private String locationName;

    @Column(name="location_coordinates", length=250)
    private String locationCoordinates;

    @Column(name="location_description", length=250)
    private String locationDescription;

    @Column(name="location_status", nullable=false)
    private long locationStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_date", nullable=false, length=23)
    private Date registeredDate;
}
