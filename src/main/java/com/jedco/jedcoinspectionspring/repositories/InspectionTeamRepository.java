package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.InspectionTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionTeamRepository extends JpaRepository<InspectionTeam,Long> {
}
