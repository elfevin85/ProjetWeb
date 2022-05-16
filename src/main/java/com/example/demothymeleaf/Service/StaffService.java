package com.example.demothymeleaf.Service;

import com.example.demothymeleaf.Domain.Customer;
import com.example.demothymeleaf.Domain.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {

    Optional<Staff> findByUsername(String s);

    List<Staff> readAllStaff();
}
