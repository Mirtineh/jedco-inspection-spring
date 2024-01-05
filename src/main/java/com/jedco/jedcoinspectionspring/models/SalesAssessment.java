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
@Table(name = "sales_assessment")
public class SalesAssessment extends BaseEntity {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection_id", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;

    @Column(name="tx_no", length=100)
    private String txNo;

    @Column(name="distance", precision=53, scale=0)
    private Double distance;

    @Column(name="northing", precision=53, scale=0)
    private Double northing;

    @Column(name="easting", precision=53, scale=0)
    private Double easting;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", length=23)
    private Date registeredOn;
}
