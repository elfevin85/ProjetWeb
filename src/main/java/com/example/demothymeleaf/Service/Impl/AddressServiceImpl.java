package com.example.demothymeleaf.Service.Impl;

import com.example.demothymeleaf.Domain.Address;
import com.example.demothymeleaf.Repository.AddressRepository;
import com.example.demothymeleaf.Service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> readAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> readOneAddress(int id) {
        return addressRepository.findById(id);
    }
}
