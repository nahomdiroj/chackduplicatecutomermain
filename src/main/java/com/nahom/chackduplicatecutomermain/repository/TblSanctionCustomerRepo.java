package com.nahom.chackduplicatecutomermain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nahom.chackduplicatecutomermain.entity.TblSanctionCustomer;

import java.util.List;


public interface TblSanctionCustomerRepo extends JpaRepository<TblSanctionCustomer, Integer>{
    List<TblSanctionCustomer> findByCustomerFullNameStartsWith(String fullName);

    List<TblSanctionCustomer> findByTelephoneStartsWith(String phone);
}
