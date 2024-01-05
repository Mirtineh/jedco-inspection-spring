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
@Table(name = "sales_assignment")
public class SalesAssignment extends BaseEntity {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="priority_level", nullable=false)
    private Priority priority;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sales_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="assigned_by", nullable=false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="salesSentDate", nullable=false, length=23)
    private Date salesSentDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="salesAcceptedDate", length=23)
    private Date salesAcceptedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="salesCompletedDate", length=23)
    private Date salesCompletedDate;

    @Column(name="customer_details")
    private String customerDetails;

    @Column(name="sales_result")
    private String salesResult;

    @Column(name="note")
    private String note;
}
