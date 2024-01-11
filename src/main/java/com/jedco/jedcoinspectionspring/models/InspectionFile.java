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
@Table(name = "inspection_files")
public class InspectionFile extends BaseEntity{
    @Column(name="file_name", nullable=false, length=100)
    private String fileName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="file_uploaded_on", length=23)
    private Date fileUploadedOn;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="inspection_id", nullable=false)
    private Inspection inspection;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="file_status", nullable=false)
    private Status status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="file_uploaded_by", nullable=false)
    private User user;
}
