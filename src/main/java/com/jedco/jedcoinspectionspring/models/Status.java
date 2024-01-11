package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_status")
public class Status extends BaseEntity {

    @Column(name="name", nullable=false, length=100)
    private String name;

    @Column(name="description", length=200)
    private String description;

    @OneToMany(fetch= FetchType.LAZY, mappedBy="status")
    private Set<User> users = new HashSet<User>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<InspectionTeam> inspectionTeams = new HashSet<InspectionTeam>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<Person> persons = new HashSet<Person>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<SalesAssignment> salesAssignments = new HashSet<SalesAssignment>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<TeamMember> teamMembers = new HashSet<TeamMember>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    private Set<RoleDefinition> roleDefinitions = new HashSet<RoleDefinition>(0);

}
