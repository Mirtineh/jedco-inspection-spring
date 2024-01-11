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
@Table(name = "user_action")
public class UserAction extends BaseEntity{
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="actionGroup", nullable=false)
    private ActionGroup actionGroup;

    @Column(name="action", length=100)
    private String action;

    @OneToMany(fetch=FetchType.EAGER, mappedBy="userAction")
    private Set<RoleDefinition> roleDefinitions = new HashSet<RoleDefinition>(0);

}
