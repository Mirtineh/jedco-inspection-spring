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
@Table(name = "priorities")
public class Priority extends BaseEntity{
    @Column(name="name", nullable=false, length=100)
    private String name;
    @Column(name="description", length=250)
    private String description;
}
