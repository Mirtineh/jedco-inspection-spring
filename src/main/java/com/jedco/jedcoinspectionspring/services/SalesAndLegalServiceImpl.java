package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.Util.Day;
import com.jedco.jedcoinspectionspring.models.Inspection;
import com.jedco.jedcoinspectionspring.repositories.InspectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesAndLegalServiceImpl implements SalesAndLegalService {
    private final InspectionRepository inspectionRepository;
    private final DateConverter dateConverter;
    @Override
//    public Page<Inspection> getAllInspectionsData(Long statusId, String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses,String problemType, Pageable pageable) {
//        Day day = dateConverter.convertBetweenDays(startDateString, endDateString);
//        Page<Inspection> inspectionPage;
//        if(day!=null){
//            if (statuses == null || statuses.isEmpty()) {
//                if (customerName != null && meterNumber != null) {
//                    if(legalCaseNo !=null && !legalCaseNo.isEmpty()){
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), customerName, meterNumber, legalCaseNo, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), customerName, meterNumber, pageable);
//                    }
//                } else if (customerName != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), customerName, legalCaseNo, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), customerName, pageable);
//                    }
//                } else if (meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), meterNumber, legalCaseNo, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), meterNumber, pageable);
//                    }
//                } else {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndLegalCaseNoContainingIgnoreCase(
//                                statusId, day.startTime(), day.endTime(), legalCaseNo, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetween(statusId, day.startTime(), day.endTime(), pageable);
//                    }
//                }
//            }
//            else {
//                if (customerName != null && meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), customerName, meterNumber,legalCaseNo, statuses, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), customerName, meterNumber, statuses, pageable);
//                    }
//                } else if (customerName != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), customerName,legalCaseNo, statuses, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), customerName, statuses, pageable);
//                    }
//                } else if (meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), meterNumber,legalCaseNo, statuses, pageable);
//                    }
//                    else {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), meterNumber, statuses, pageable);
//                    }
//                } else {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(),legalCaseNo, statuses, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndRegisteredOnBetweenAndStatusIdIn(
//                                statusId, day.startTime(), day.endTime(), statuses, pageable);
//                    }
//                }
//            }
//        }
//        else {
//            if (statuses == null || statuses.isEmpty()) {
//                if (customerName != null && meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, customerName, meterNumber,legalCaseNo, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
//                                statusId, customerName, meterNumber, pageable);
//                    }
//                } else if (customerName != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, customerName,legalCaseNo, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCase(
//                                statusId, customerName, pageable);
//                    }
//                } else if (meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCase(
//                                statusId, meterNumber,legalCaseNo, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCase(
//                                statusId, meterNumber, pageable);
//                    }
//                } else {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndLegalCaseNoContainingIgnoreCase(statusId,legalCaseNo, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqual(statusId, pageable);
//                    }
//                }
//            }
//            else {
//                if (customerName != null && meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, customerName, meterNumber, legalCaseNo, statuses, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, customerName, meterNumber, statuses, pageable);
//                    }
//                } else if (customerName != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, customerName, legalCaseNo, statuses, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
//                                statusId, customerName, statuses, pageable);
//                    }
//                } else if (meterNumber != null) {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, meterNumber, legalCaseNo, statuses, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndMeterNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, meterNumber, statuses, pageable);
//                    }
//                } else {
//                    if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndLegalCaseNoContainingIgnoreCaseAndStatusIdIn(
//                                statusId, legalCaseNo, statuses, pageable);
//                    }
//                    else{
//                        inspectionPage = inspectionRepository.findAllByStatusIdIsGreaterThanEqualAndStatusIdIn(
//                                statusId, statuses, pageable);
//                    }
//                }
//            }
//        }
//        return inspectionPage;
//    }

    public Page<Inspection> getAllInspectionsData(Long statusId, String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, Pageable pageable) {
        Day day = dateConverter.convertBetweenDays(startDateString, endDateString);
        Page<Inspection> inspectionPage;

        Specification<Inspection> spec = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("status").get("id"), statusId));

        if (day != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("registeredOn"), day.startTime(), day.endTime()));
        }

        if (statuses != null && !statuses.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> root.get("status").get("id").in(statuses));
        }

        if (customerName != null && !customerName.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("customerName")), "%" + customerName.toLowerCase() + "%"));
        }

        if (meterNumber != null && !meterNumber.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("meterNo")), "%" + meterNumber.toLowerCase() + "%"));
        }

        if (legalCaseNo != null && !legalCaseNo.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("legalCaseNo")), "%" + legalCaseNo.toLowerCase() + "%"));
        }

        if (problemType != null && !problemType.isEmpty()) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("problemTypes")),"%"+problemType.toLowerCase()+"%"));
        }

        inspectionPage = inspectionRepository.findAll(spec, pageable);

        return inspectionPage;
    }
}
