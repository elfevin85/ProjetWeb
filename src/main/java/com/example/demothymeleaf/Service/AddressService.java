package com.example.demothymeleaf.Service;

import com.example.demothymeleaf.Domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> readAllAddress();
    Optional<Address> readOneAddress(int id);
}
