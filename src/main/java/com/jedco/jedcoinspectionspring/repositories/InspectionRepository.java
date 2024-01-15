package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InspectionRepository extends JpaRepository<Inspection,Long> {
    List<Inspection> findAllByStatusId_NotAndRegisteredOnBetween(Long deletedStatus, Date date, Date date1);

    List<Inspection> findAllByStatusIdAndRegisteredOnBetween(Long statusId, Date date, Date date1);

    List<Inspection> findAllByStatusIdGreaterThanAndRegisteredOnBetween(Long legalStatusId, Date date, Date date1);
}
