package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.StatusResponse;

import java.util.List;

public interface StatusService {
    List<StatusResponse> listAll();
}
