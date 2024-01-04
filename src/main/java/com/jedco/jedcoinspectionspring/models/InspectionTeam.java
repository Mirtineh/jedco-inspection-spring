package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inspection_team")
public class InspectionTeam extends BaseEntity {
    @Column(name="teamName", nullable=false, length=100)
    private String teamName;

    @Column(name="description", length=250)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false, length=23)
    private Date createdDate;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="team_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="team_leader", nullable=false)
    private Person teamLeader;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inspectionTeam")
    private Set<TeamMember> teamMembers = new HashSet<TeamMember>(0);

}
