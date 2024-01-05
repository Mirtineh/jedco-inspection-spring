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
@Table(name = "quotations")
public class Quotation extends BaseEntity{

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection_id", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;

    @Column(name="quotation_ref", length=100)
    private String quotationRef;

    @Column(name="amount", nullable=false, precision=53, scale=0)
    private double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", length=23)
    private Date registeredOn;
}
