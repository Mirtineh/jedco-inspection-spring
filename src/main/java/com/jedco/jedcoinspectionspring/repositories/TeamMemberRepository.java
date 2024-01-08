package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamMemberRepository extends JpaRepository<TeamMember,Long> {
}
