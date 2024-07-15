package com.nahom.chackduplicatecutomermain.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nahom.chackduplicatecutomermain.entity.TblSanctionCustomer;
import com.nahom.chackduplicatecutomermain.repository.TblSanctionCustomerRepo;
import com.nahom.chackduplicatecutomermain.services.TblSanctionCustomerService;
import com.nahom.chackduplicatecutomermain.services.util.SpecialCahConverter;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;


@Service
@Transactional
@Slf4j
public class TblSanctionCustomerServiceImpl implements TblSanctionCustomerService {
    private TblSanctionCustomerRepo sanctionCustomerRepo;

    @Autowired
    public TblSanctionCustomerServiceImpl(TblSanctionCustomerRepo customerRepo) {
        this.sanctionCustomerRepo = customerRepo;
    }


    @Override
    public Collection<TblSanctionCustomer> findDeliquentByFullName(String fullName) {
        SpecialCahConverter s = new SpecialCahConverter();
        String name = s.convertName(fullName);
        String namefinal = s.replaceSpecialChar(name);
        log.info("Fetch sanction customer by fullName: {}", sanctionCustomerRepo.findByCustomerFullNameStartsWith(namefinal));
        
        return sanctionCustomerRepo.findByCustomerFullNameStartsWith(namefinal);
    }

    @Override
    public Collection<TblSanctionCustomer> findSanctionByPhone(String name) {
        log.info("Fetch sanction customer by phone: {}", sanctionCustomerRepo.findByTelephoneStartsWith(name));

        return sanctionCustomerRepo.findByTelephoneStartsWith(name);
    }
}
