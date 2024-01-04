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
@Table(name = "inspection_codes")
public class InspectionCode extends BaseEntity {

    @Column(name="meter_type", nullable=false, length=10)
    private String meterType;

    @Column(name="code", nullable=false, length=10)
    private String code;

    @Column(name="description", length=100)
    private String description;
}
