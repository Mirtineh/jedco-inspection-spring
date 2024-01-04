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
@Table(name = "inspection_assesment")
public class InspectionAssessment extends BaseEntity {
    @Column(name="customer_type", length=100)
    private String customerType;

    @Column(name="presented_document", length=100)
    private String presentedDocument;

    @Column(name="reason", length=100)
    private String reason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", nullable=false, length=23)
    private Date registeredOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=23)
    private Date updatedOn;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="assesment_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inspectionAssesment")
    private Set<CustomerLoad> customerLoads = new HashSet<CustomerLoad>(0);

}
