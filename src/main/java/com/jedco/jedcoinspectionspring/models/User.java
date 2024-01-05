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
@Table(name = "users")
public class User extends BaseEntity{

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_role", nullable=false)
    private UserRole userRole;

    @Column(name="first_name", nullable=false, length=100)
    private String firstName;

    @Column(name="last_name", length=100)
    private String lastName;

    @Column(name="phone_no", nullable=false, length=250)
    private String phoneNo;

    @Column(name="email", length=250)
    private String email;

    @Column(name="username", length=100)
    private String username;

    @Column(name="password", length=1000)
    private String password;

    @Column(name="registered_by", nullable=false)
    private long registeredBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_date", nullable=false, length=23)
    private Date registeredDate;

    @Column(name="password_index")
    private Long passwordIndex;

    @Column(name="change_count")
    private Long changeCount;

    @Column(name="activation_no", length=100)
    private String activationNo;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<Inspection> inspections = new HashSet<Inspection>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<InspectionTeam> inspectionTeams = new HashSet<InspectionTeam>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<CheckListResult> installationChecklists = new HashSet<CheckListResult>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<CodeResult> codeResults = new HashSet<CodeResult>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<SalesAssignment> salesAssignments = new HashSet<SalesAssignment>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    private Set<TeamMember> teamMembers = new HashSet<TeamMember>(0);

    @OneToMany(fetch=FetchType.LAZY, mappedBy= "registeredBy")
    private Set<Person> persons = new HashSet<Person>(0);

}
