package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    @Override
    public ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username) {
        return null;
    }

    @Override
    public List<PriorityResponse> priorityList() {
        return null;
    }

    @Override
    public List<InspectionResponse> inspectionsListByDate(String startDate, String endDate, String username) {
        return null;
    }

    @Override
    public List<InspectionResponse> adminInspectionsListByDate(String startDate, String endDate, String username) {
        return null;
    }

    @Override
    public List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId) {
        return null;
    }

    @Override
    public List<InspectionCodesResponse> inspectionCodesList(String meterType) {
        return null;
    }

    @Override
    public ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username) {
        return null;
    }
}
