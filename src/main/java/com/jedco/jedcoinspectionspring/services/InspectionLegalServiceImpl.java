package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionLegalServiceImpl implements InspectionLegalService {
    @Override
    public List<InspectionSalesResponse> legalInspectionsListByDate(String startDate, String endDate) {
        return null;
    }

    @Override
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String username) {
        return null;
    }
}
