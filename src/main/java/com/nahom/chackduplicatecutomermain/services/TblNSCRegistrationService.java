package com.nahom.chackduplicatecutomermain.services;


import java.util.Collection;

import com.nahom.chackduplicatecutomermain.entity.TblNSCRegistration;

public interface TblNSCRegistrationService {
        Collection<TblNSCRegistration> findDeliquentByTin(String tin);

        Collection<TblNSCRegistration> findDeliquentByFullName(String fullName);

        Collection<TblNSCRegistration> findSanctionByPhone(String name);
}
