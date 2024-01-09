package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;

import java.util.List;

public interface ProblemTypeService {
    public List<String> listAll();
    public List<ProblemTypeResponse> getProblemTypes();
}
