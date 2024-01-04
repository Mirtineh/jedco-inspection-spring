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
@Table(name = "persons")
public class Person extends BaseEntity{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="person_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User registeredBy;

    @Column(name="first_name", length=100)
    private String firstName;

    @Column(name="last_name", length=100)
    private String lastName;

    @Column(name="phone_no", length=100)
    private String phoneNo;

    @Column(name="email", length=100)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registerationDate", length=23)
    private Date registerationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="terminationDate", length=23)
    private Date terminationDate;

    @Column(name="membershipType", length=100)
    private String membershipType;

    @Column(name="team_id")
    private Long teamId;
}
