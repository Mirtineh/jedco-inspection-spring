package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemTypeServiceImpl implements ProblemTypeService {
    @Override
    public List<String> listAll() {
        return null;
    }

    @Override
    public List<ProblemTypeResponse> getProblemTypes() {
        return null;
    }
}
