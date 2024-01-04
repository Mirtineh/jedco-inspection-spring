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
@Table(name = "checklist_result")
public class CheckListResult extends BaseEntity{
    @Column(name="checklist_status", nullable=false)
    private boolean checklistStatus;

    @Column(name="remark", length=250)
    private String remark;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="registered_on", nullable=false, length=23)
    private Date registeredOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_on", length=23)
    private Date updatedOn;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="checklist", nullable=false)
    private CheckList checkList;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inspection", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="registered_by", nullable=false)
    private User users;

}
