package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.StatusMapper;
import com.jedco.jedcoinspectionspring.models.Status;
import com.jedco.jedcoinspectionspring.repositories.StatusRepository;
import com.jedco.jedcoinspectionspring.rest.responses.StatusResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;
    @Override
    public List<StatusResponse> listAll() {
        List<Status> statusList= statusRepository.findAll();
        return statusList.stream().map(statusMapper::toStatusResponse).toList();
    }
}
