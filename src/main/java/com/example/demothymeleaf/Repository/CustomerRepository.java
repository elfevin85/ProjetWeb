package com.example.demothymeleaf.Repository;

import com.example.demothymeleaf.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<Object> getCustomerDetailsByName(String name);
}
