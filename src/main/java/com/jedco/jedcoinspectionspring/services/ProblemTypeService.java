package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;

import java.util.List;

public interface ProblemTypeService {
    List<String> listAll();

    List<ProblemTypeResponse> getProblemTypes();
}
