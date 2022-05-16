package com.example.demothymeleaf.Service;

import com.example.demothymeleaf.Domain.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> readOneCustomer(int id);

    Collection<Customer> search(String query);

    List<Customer> readAllCustomer();

    void deleteCustomer(int id);

    List<Customer> getAll();

    Optional<Object> detailsByName(String name);

    Collection<Customer> searchCustomer(String query);

    List<Customer> getByFirstNameAnsLastName(String firstName, String LastName);


    Optional<Customer> getDetailByName(String name);
}
