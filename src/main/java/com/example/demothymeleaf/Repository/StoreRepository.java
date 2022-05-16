package com.example.demothymeleaf.Repository;

import com.example.demothymeleaf.Domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
