package com.example.demothymeleaf.Service;

import com.example.demothymeleaf.Domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Store> readAllStore();
    Optional<Store> readOne(int id);
}
