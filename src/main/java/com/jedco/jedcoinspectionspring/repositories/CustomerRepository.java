package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
