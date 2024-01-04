package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "action_group")
public class ActionGroup extends BaseEntity {
    @Column(name="name", length=100)
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "actionGroup")
    private List<UserAction> userActions = new ArrayList<>();
}
