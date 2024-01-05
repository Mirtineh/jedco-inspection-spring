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
@Table(name = "task_history")
public class TaskHistory extends BaseEntity {

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="action_by", nullable=false)
    private User actionBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="action_date", length=23)
    private Date actionDate;

    @Column(name="additional_note", length=900)
    private String additionalNote;

    @Column(name="history_details", length=900)
    private String historyDetails;

    @Column(name="action_type", length=200)
    private String actionType;
}
