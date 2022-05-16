package com.example.demothymeleaf.Service.Impl;

import com.example.demothymeleaf.Domain.Customer;
import com.example.demothymeleaf.Repository.CustomerRepository;
import com.example.demothymeleaf.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> readOneCustomer(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Collection<Customer> search(String query) {
        final String lowercaseQuery = query.toLowerCase();
        return getAll().stream().filter(c ->c.getFirstName().toLowerCase().contains(query) ||
                                        c.getLastName().toLowerCase().contains(query))
                                        .collect(Collectors.toList());
    }


    @Override
    public List<Customer> readAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Object> detailsByName(String name) {
        return customerRepository.getCustomerDetailsByName(name);
    }

    @Override
    public Collection<Customer> searchCustomer(String query) {
        return readAllCustomer().stream().filter(
                        c -> c.getFirstName()
                                .toLowerCase()
                                .startsWith(query.toLowerCase())
                                || c.getLastName()
                                .toLowerCase()
                                .startsWith(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getByFirstNameAnsLastName(String firstName, String LastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, LastName);
    }
    @Override
    public Optional<Customer> getDetailByName(String name){
        return readAllCustomer().stream().filter(
                c-> Objects.equals(c.getFirstName().toLowerCase(), name.toLowerCase())
        ).findAny();
    }
}