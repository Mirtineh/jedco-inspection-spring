package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListRepository extends JpaRepository<CheckList,Long> {
}
