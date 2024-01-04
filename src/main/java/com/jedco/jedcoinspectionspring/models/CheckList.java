package com.jedco.jedcoinspectionspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "check_list")
public class CheckList extends BaseEntity {
    @Column(name="checkList", nullable=false, length=100)
    private String checkList;
    @Column(name="description", length=250)
    private String description;
}
