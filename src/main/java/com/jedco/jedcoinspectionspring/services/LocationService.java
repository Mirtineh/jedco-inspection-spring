package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.LocationResponse;

import java.util.List;

public interface LocationService {
    public List<LocationResponse> listAll();
}
