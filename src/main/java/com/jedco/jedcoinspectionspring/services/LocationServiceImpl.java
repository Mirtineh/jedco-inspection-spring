package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.LocationMapper;
import com.jedco.jedcoinspectionspring.models.Location;
import com.jedco.jedcoinspectionspring.repositories.LocationRepository;
import com.jedco.jedcoinspectionspring.rest.responses.LocationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;
    @Override
    public List<LocationResponse> listAll() {
        List<Location> locations= locationRepository.findAll();
        return locations.stream().map(locationMapper::toLocationResponse).toList();
    }
}
