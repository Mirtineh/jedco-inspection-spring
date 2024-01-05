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
@Table(name = "team_members")
public class TeamMember extends BaseEntity {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="team_id", nullable=false)
    private InspectionTeam inspectionTeam;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id", nullable=false)
    private Person person;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="status_id", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false, length=23)
    private Date createdDate;
}
