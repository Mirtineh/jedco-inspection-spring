package com.jedco.jedcoinspectionspring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PagingServiceImpl implements PagingService {
    @Override
    public Pageable createPageable(int page, int limit, String sort) {
        if (sort != null && !sort.isEmpty()) {
            String[] sortParts = sort.split("%");
            String sortBy = sortParts[0];
            Sort.Direction sortDirection = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

            // Create a mapping between request parameter names and entity fields
            Map<String, String> fieldMappings = Map.of(
                    "registeredDate", "registeredOn",
                    "metterNumber", "meterNo"
                    // Add more mappings as needed
            );

            // Use the mapping to get the actual field name
            String mappedField = fieldMappings.getOrDefault(sortBy, sortBy);

            return PageRequest.of(page - 1, limit, Sort.by(sortDirection, mappedField));
        } else {
            return PageRequest.of(page - 1, limit);
        }
    }

    @Override
    public Pageable createPageable(String sort) {
        if (sort != null && !sort.isEmpty()) {
            String[] sortParts = sort.split("%");
            String sortBy = sortParts[0];
            Sort.Direction sortDirection = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

            // Create a mapping between request parameter names and entity fields
            Map<String, String> fieldMappings = Map.of(
                    "registeredDate", "registeredOn",
                    "metterNumber", "meterNo"
                    // Add more mappings as needed
            );

            // Use the mapping to get the actual field name
            String mappedField = fieldMappings.getOrDefault(sortBy, sortBy);

            return PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortDirection, mappedField));
        } else {
            return Pageable.unpaged();
        }
    }
}
