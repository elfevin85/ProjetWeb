package com.example.demothymeleaf.Service.Impl;

import com.example.demothymeleaf.Domain.Store;
import com.example.demothymeleaf.Repository.StoreRepository;
import com.example.demothymeleaf.Service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> readAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> readOne(int id) {
        return storeRepository.findById(id);
    }
}
