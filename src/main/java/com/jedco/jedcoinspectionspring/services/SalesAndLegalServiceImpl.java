package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.Util.Day;
import com.jedco.jedcoinspectionspring.models.Inspection;
import com.jedco.jedcoinspectionspring.repositories.InspectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesAndLegalServiceImpl implements SalesAndLegalService {
    private final InspectionRepository inspectionRepository;
    private final DateConverter dateConverter;
    @Override
    public Page<Inspection> getAllInspectionsData(Long statusId, String startDateString, String endDateString, String customerName, String meterNumber, List<Long> statuses, Pageable pageable) {
        Day day = dateConverter.convertBetweenDays(startDateString, endDateString);
        Page<Inspection> inspectionPage;
        if(day!=null){
            if (statuses == null || statuses.isEmpty()) {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
                            statusId, day.startTime(), day.endTime(), customerName, meterNumber, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(
                            statusId, day.startTime(), day.endTime(), customerName, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(
                            statusId, day.startTime(), day.endTime(), meterNumber, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetween(statusId, day.startTime(), day.endTime(), pageable);
                }
            }
            else {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            statusId, day.startTime(), day.endTime(), customerName, meterNumber, statuses, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
                            statusId, day.startTime(), day.endTime(), customerName, statuses, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            statusId, day.startTime(), day.endTime(), meterNumber, statuses, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndStatusIdIn(
                            statusId, day.startTime(), day.endTime(), statuses, pageable);
                }
            }
        }
        else {
            if (statuses == null || statuses.isEmpty()) {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
                            statusId, customerName, meterNumber, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCase(
                            statusId, customerName, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCase(
                            statusId, meterNumber, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqual(statusId, pageable);
                }
            }
            else {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            statusId, customerName, meterNumber, statuses, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
                            statusId, customerName, statuses, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            statusId, meterNumber, statuses, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndStatusIdIn(
                            statusId, statuses, pageable);
                }
            }
        }
        return inspectionPage;
    }
}
