package com.example.demothymeleaf.Service.Impl;

import com.example.demothymeleaf.Domain.Staff;
import com.example.demothymeleaf.Repository.StaffRepository;
import com.example.demothymeleaf.Service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Optional<Staff> findByUsername(String s) {
        return readAllStaff().stream().filter(
                c-> Objects.equals(c.getUsername().toLowerCase(), s.toLowerCase())
        ).findAny();
    }

    @Override
    public List<Staff> readAllStaff() {
        return staffRepository.findAll();
    }


}
