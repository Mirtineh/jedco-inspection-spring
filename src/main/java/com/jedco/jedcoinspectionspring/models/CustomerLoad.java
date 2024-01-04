package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_load")
public class CustomerLoad extends BaseEntity {
    @Column(name="power_rate", precision=10)
    private BigDecimal powerRate;

    @Column(name="quantity", precision=10)
    private BigDecimal quantity;

    @Column(name="total_kwh", precision=10)
    private BigDecimal totalKwh;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", nullable=false, length=23)
    private Date registeredOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=23)
    private Date updatedOn;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="equipment", nullable=false)
    private Equipment equipment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="assesment", nullable=false)
    private InspectionAssessment inspectionAssesment;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="load_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;
}
