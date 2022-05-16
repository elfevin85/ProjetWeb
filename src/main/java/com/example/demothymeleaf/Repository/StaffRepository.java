package com.example.demothymeleaf.Repository;

import com.example.demothymeleaf.Domain.Customer;
import com.example.demothymeleaf.Domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff,Integer> {
    Optional<Staff> findByUsername(String s);
}
