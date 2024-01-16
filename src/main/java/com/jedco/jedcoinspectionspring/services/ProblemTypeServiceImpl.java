package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.ProblemTypeMapper;
import com.jedco.jedcoinspectionspring.models.ProblemType;
import com.jedco.jedcoinspectionspring.repositories.ProblemTypeRepository;
import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProblemTypeServiceImpl implements ProblemTypeService {
    private final ProblemTypeRepository problemTypeRepository;
    private final ProblemTypeMapper problemTypeMapper;
    @Override
    public List<String> listAll() {
        List<ProblemType> problemTypes = problemTypeRepository.findAll();
        return problemTypes.stream().map(ProblemType::getProblemType).toList();
    }

    @Override
    public List<ProblemTypeResponse> getProblemTypes() {
        List<ProblemType> problemTypes = problemTypeRepository.findAll();
        return problemTypes.stream().map(problemTypeMapper::toProblemTypeResponse).toList();
    }
}
