package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipments")
public class Equipment extends BaseEntity{
    @Column(name="name", length=100)
    private String name;

    @Column(name="description", length=100)
    private String description;
}
