package com.jedco.jedcoinspectionspring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface PagingService {
    Pageable createPageable(int page, int limit, String sort);
    Pageable createPageable(String sort);
}
