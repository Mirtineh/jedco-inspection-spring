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
@Table(name = "problem_types")
public class ProblemType extends BaseEntity{
    @Column(name="problem_type", nullable=false, length=100)
    private String problemType;
    @Column(name="type_description", length=250)
    private String typeDescription;
}
