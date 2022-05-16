package com.example.demothymeleaf.Repository;

import com.example.demothymeleaf.Domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
