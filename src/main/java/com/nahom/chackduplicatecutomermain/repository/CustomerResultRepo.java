package com.nahom.chackduplicatecutomermain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nahom.chackduplicatecutomermain.customer.CustomerResult;



@Repository
public interface CustomerResultRepo extends JpaRepository<CustomerResult, Long> {
}
