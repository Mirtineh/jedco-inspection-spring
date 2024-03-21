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
@Table(name = "uploaded_files")
public class UploadedFile extends BaseEntity {
    @Column(name="file_name", nullable = false, length = 100)
    private String name;

    @Column(name="path", nullable = false, length = 1000)
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "uploaded_on", nullable = false, length = 100)
    private Date uploadedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="uploaded_by", nullable = false)
    private User uploadedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="task_history_id", nullable = false)
    private TaskHistory taskHistory;

}
