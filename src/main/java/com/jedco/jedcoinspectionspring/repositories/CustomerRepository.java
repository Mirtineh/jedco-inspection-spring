package com.jedco.jedcoinspectionspring.repositories;

import com.jedco.jedcoinspectionspring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Optional<Customer> findFirstByMeterNo(String meterNo);
}
