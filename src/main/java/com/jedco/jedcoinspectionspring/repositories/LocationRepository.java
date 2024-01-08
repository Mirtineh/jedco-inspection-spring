package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
