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
@Table(name = "code_results")
public class CodeResult extends BaseEntity {
    @Column(name="result", nullable=false, length=100)
    private String result;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", nullable=false, length=23)
    private Date registeredOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=23)
    private Date updatedOn;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="code", nullable=false)
    private InspectionCode inspectionCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inspection", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User user;
}
