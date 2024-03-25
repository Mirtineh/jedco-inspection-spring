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

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetween(Long salesStatusId, Date date, Date date1,Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetween(Long deletedStatus, Date date, Date date1, Pageable pageable);

    Page<Inspection> findAllByStatusIdNot(Long deletedStatus, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(Long deletedStatus, Date date, Date date1, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long deletedStatus, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCase(Long deletedStatus, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndMeterNoContainingIgnoreCase(Long deletedStatus, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, Date date, Date date1, String customerName, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, Date date, Date date1, String customerName, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, Date date, Date date1, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndRegisteredOnBetweenAndStatusIdIn(Long deletedStatus, Date date, Date date1, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, String customerName, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, String customerName, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long deletedStatus, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdNotAndStatusIdIn(Long deletedStatus, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long salesStatusId, Date date, Date date1, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(Long salesStatusId, Date date, Date date1, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(Long salesStatusId, Date date, Date date1, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, Date date, Date date1, String customerName, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, Date date, Date date1, String customerName, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, Date date, Date date1, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndStatusIdIn(Long salesStatusId, Date date, Date date1, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(Long salesStatusId, String customerName, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCase(Long salesStatusId, String customerName, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCase(Long salesStatusId, String meterNumber, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqual(Long salesStatusId, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, String customerName, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, String customerName, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndStatusIdIn(Long salesStatusId, String meterNumber, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndStatusIdIn(Long salesStatusId, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, Date date, Date date1, String customerName, String meterNumber, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, Date date, Date date1, String customerName, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, Date date, Date date1, String meterNumber, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndLegalCaseNoContainingIgnoreCase(Long statusId, Date date, Date date1, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, String customerName, String meterNumber, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, String customerName, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(Long statusId, String meterNumber, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndLegalCaseNoContainingIgnoreCase(Long statusId, String legalCaseNo, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, String customerName, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, String meterNumber, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, Date date, Date date1, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, Date date, Date date1, String customerName, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, Date date, Date date1, String meterNumber, String legalCaseNo, List<Long> statuses, Pageable pageable);

    Page<Inspection> findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(Long statusId, Date date, Date date1, String legalCaseNo, List<Long> statuses, Pageable pageable);
}
