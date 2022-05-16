package com.example.demothymeleaf.Service.mapping;

import com.example.demothymeleaf.Domain.Address;
import com.example.demothymeleaf.Domain.Customer;
import com.example.demothymeleaf.Domain.Store;
import com.example.demothymeleaf.Service.dto.CustomerDTO;

import java.sql.Timestamp;

public final class CustomerMapping {
    private CustomerMapping() {
    }
    public static Customer populateCustomer(CustomerDTO customerDTO,
                                            Address address, Store store, Timestamp createdDate, Timestamp
                                                    lastUpdate, int customerid) {
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setLastName(customerDTO.getLastName());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setAddress(address);
        customer.setStore(store);
        customer.setActive((byte) (customerDTO.getActive() ? 1 : 0));
        customer.setCreateDate(createdDate);
        customer.setLastUpdate(lastUpdate);
        customer.setCustomerId(customerid);
        return customer;
    }
}
