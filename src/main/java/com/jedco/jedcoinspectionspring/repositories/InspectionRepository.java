package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.Inspection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InspectionRepository extends JpaRepository<Inspection,Long> {
    List<Inspection> findAllByStatusId_NotAndRegisteredOnBetween(Long deletedStatus, Date date, Date date1);

    List<Inspection> findAllByStatusIdAndRegisteredOnBetween(Long statusId, Date date, Date date1);

    List<Inspection> findAllByStatusIdGreaterThanAndRegisteredOnBetween(Long legalStatusId, Date date, Date date1);

    List<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetween(Long salesStatusId, Date date, Date date1);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetween(Long deletedStatus, Date date, Date date1, Pageable pageable);

    Page<Inspection> findAllByStatusIdNot(Long deletedStatus, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long deletedStatus, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCase(Long deletedStatus, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndMeterNoContainingIgnoreCase(Long deletedStatus, String meterNumber, Pageable pageable);
}
